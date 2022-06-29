package com.mdsbooking.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsbooking.dto.ExistingHouseDTO;
import com.mdsbooking.dto.FilterDTO;
import com.mdsbooking.dto.NewHouseDTO;
import com.mdsbooking.exception.HouseNotFoundException;
import com.mdsbooking.filter.FilterFactory;
import com.mdsbooking.mapper.HouseResultTransformer;
import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseComodity;
import com.mdsbooking.model.HouseId;
import com.mdsbooking.model.HouseIdFK;
import com.mdsbooking.model.HouseImage;
import com.mdsbooking.model.HouseImageId;
import com.mdsbooking.model.User;
import com.mdsbooking.repository.IHouseRepository;

@Service
@Transactional
public class HouseService extends BaseService<IHouseRepository> {

	@Autowired
	private AwsService awsService;

	@Autowired
	private UserService userService;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager em;

	public ExistingHouseDTO addNewHouse(NewHouseDTO newHouse) {
		log.info("Adding new house for user {}", newHouse.getUserId());
		User user = userService.findById(newHouse.getUserId());
		HouseId houseId = new HouseId();
		houseId.setUserId(newHouse.getUserId());
		houseId.setId(user.getHouses().size() + 1);
		House house = modelMapper.map(newHouse, House.class);
		house.setImages(new HashSet<>());
		house.setId(houseId);
		int imageId = 1;
		for (String image : newHouse.getImages()) {
			HouseImageId houseImageId = new HouseImageId();
			HouseImage newImage = new HouseImage();
			newImage.setId(houseImageId);
			newImage.setHouse(house);
			HouseIdFK houseFKId = new HouseIdFK();
			houseFKId.setHouseId(house.getId().getId());
			houseFKId.setUserId(user.getId());
			houseImageId.setHouseFKId(houseFKId);
			houseImageId.setUrl(awsService.uploadImage(user.getId().toString(), houseId.getId().toString(), image,
					Integer.toString(imageId++)));
			house.getImages().add(newImage);
		}
		for (HouseComodity comodity : house.getComodities()) {
			comodity.getId().setHouseId(house.getId().getId());
			comodity.getId().setUserId(user.getId());
		}
		house.setUser(user);
		try {
			house = classRepository.saveAndFlush(house);
		} catch (Exception e) {
			log.error("Error while saving new house for user {}", user.getId(), e);
			awsService.deleteImages(user.getId().toString(), house.getId().getId().toString());
		}
		ExistingHouseDTO response = modelMapper.map(house, ExistingHouseDTO.class);
		log.info("New house {} added for user {}", house.getId().getId(), newHouse.getUserId());
		return response;
	}

	public House findById(Long userId, Integer house) {
		log.info("Finding house {} for user {}", house, userId);
		HouseId houseId = new HouseId();
		houseId.setId(house);
		houseId.setUserId(userId);
		return classRepository.findById(houseId)
				.orElseThrow(() -> new HouseNotFoundException("House not found", "House is not in database"));
	}

	public List<ExistingHouseDTO> getRandomHouses() {
		log.info("Getting random houses");
		long maxPages = classRepository.count() / 10;
		List<House> houses = classRepository.findAll(PageRequest.of((int) Math.floor(Math.random() * maxPages), 10))
				.getContent();
		return modelMapper.map(houses, new TypeToken<List<ExistingHouseDTO>>() {
		}.getType());
	}

	public List<ExistingHouseDTO> getUserHouses(Long userId) {
		log.info("Getting user {} houses", userId);
		List<House> houses = classRepository.findByUserId(userId);
		return modelMapper.map(houses, new TypeToken<List<ExistingHouseDTO>>() {
		}.getType());
	}

	public List<ExistingHouseDTO> findByFilters(List<FilterDTO> filters) {
		log.info("Getting houses by filters");
		List<House> houses = null;
		if (filters.isEmpty()) {
			houses = classRepository.findAll();
		} else {
			final CriteriaBuilder cb = em.getCriteriaBuilder();
			final CriteriaQuery<House> query = cb.createQuery(House.class);
			final Root<House> root = query.from(House.class);
			Predicate[] predicates = new Predicate[filters.size()];
			for (int i=0; i< filters.size(); i++) {
				FilterDTO filter = filters.get(i);
				predicates[i] = FilterFactory.getFilter(filter.getName()).addFilterToHouse(cb, root, filter.getValue());
			}
			houses = em.createQuery(query.select(root).where(predicates)).getResultList();
		}
		return modelMapper.map(houses, new TypeToken<List<ExistingHouseDTO>>() {
		}.getType());
	}

}
