package com.mdsbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.ComodityDTO;
import com.mdsbooking.service.ComodityService;

@RequestMapping("/comodity")
@RestController
public class ComodityController extends BaseController<ComodityService> {
	
	@GetMapping
	public ResponseEntity<List<ComodityDTO>> getAll(){
		return new ResponseEntity<>(classService.getAllComodities(), HttpStatus.OK);
	}

}
