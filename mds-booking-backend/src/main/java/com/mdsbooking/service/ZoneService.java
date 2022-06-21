package com.mdsbooking.service;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.mdsbooking.dto.ZoneDTO;
import com.mdsbooking.repository.IZoneRepository;

@Service
public class ZoneService extends BaseService<IZoneRepository> {

	public List<ZoneDTO> getAllZones() {
		return modelMapper.map(classRepository.findAll(), new TypeToken<List<ZoneDTO>>() {}.getType());
	}

}
