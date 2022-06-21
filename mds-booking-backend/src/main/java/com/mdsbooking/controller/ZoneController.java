package com.mdsbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.ZoneDTO;
import com.mdsbooking.service.ZoneService;

@RequestMapping("/zone")
@RestController
public class ZoneController extends BaseController<ZoneService> {
	
	@GetMapping
	public ResponseEntity<List<ZoneDTO>> getAll(){
		return new ResponseEntity<>(classService.getAllZones(), HttpStatus.OK);
	}

}
