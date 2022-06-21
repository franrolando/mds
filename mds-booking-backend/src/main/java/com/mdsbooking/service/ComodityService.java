package com.mdsbooking.service;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.mdsbooking.dto.ComodityDTO;
import com.mdsbooking.repository.IComodityRepository;

@Service
public class ComodityService extends BaseService<IComodityRepository> {

	public List<ComodityDTO> getAllComodities(){
		return modelMapper.map(classRepository.findAll(), new TypeToken<List<ComodityDTO>>() {}.getType());
	}
	
}
