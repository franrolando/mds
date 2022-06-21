package com.mdsbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsbooking.dto.InquiryDTO;
import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseIdFK;
import com.mdsbooking.model.Inquiry;
import com.mdsbooking.model.InquiryId;
import com.mdsbooking.repository.IInquiryRepository;

@Service
@Transactional
public class InquiryService extends BaseService<IInquiryRepository> {

	@Autowired
	private HouseService houseService;

	public InquiryDTO addNewInquiry(InquiryDTO inquiry) {
		log.info("Adding new inquiry for user {} in house {}", inquiry.getUserId(), inquiry.getHouseId());
		House house = houseService.findById(inquiry.getUserId(), inquiry.getHouseId());
		InquiryId inquiryId = new InquiryId();
		HouseIdFK houseId = new HouseIdFK();
		houseId.setHouseId(inquiry.getHouseId());
		houseId.setUserId(inquiry.getUserId());
		inquiryId.setHouseFKId(houseId);
		inquiryId.setInquiryId(Integer.toUnsignedLong(house.getInquiries().size() + 1));
		Inquiry newInquiry = modelMapper.map(inquiry, Inquiry.class);
		newInquiry.setId(inquiryId);
		newInquiry.setHouse(null);
		return modelMapper.map(classRepository.save(newInquiry), InquiryDTO.class);
	}

}
