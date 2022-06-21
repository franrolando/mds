package com.mdsbooking.service;

import java.util.HashSet;
import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsbooking.dto.ExistingHouseDTO;
import com.mdsbooking.dto.FilterDTO;
import com.mdsbooking.dto.NewHouseDTO;
import com.mdsbooking.exception.HouseNotFoundException;
import com.mdsbooking.filter.FilterFactory;
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
		house = classRepository.save(house);
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
			House houseExample = new House();
			filters.forEach(filter -> {
				FilterFactory.getFilter(filter.getName()).addFilterToHouse(houseExample, filter.getValue());
			});
			ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
			Example<House> example = Example.of(houseExample, caseInsensitiveExampleMatcher);
			houses = classRepository.findAll(example);
		}
		return modelMapper.map(houses, new TypeToken<List<ExistingHouseDTO>>() {
		}.getType());
	}

}
