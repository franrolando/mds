package com.mdsbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.ExistingHouseDTO;
import com.mdsbooking.dto.FilterDTO;
import com.mdsbooking.dto.HouseDTO;
import com.mdsbooking.dto.NewHouseDTO;
import com.mdsbooking.service.HouseService;

@RequestMapping("/house")
@RestController
public class HouseController extends BaseController<HouseService> {

	@PostMapping
	public ResponseEntity<ExistingHouseDTO> addNewHouse(@RequestBody NewHouseDTO newHouse) {
		return new ResponseEntity<>(classService.addNewHouse(newHouse), HttpStatus.CREATED);
	}
	
	@GetMapping("/getRandomHouses")
	public ResponseEntity<List<ExistingHouseDTO>> getRandomHouses(){
		return new ResponseEntity<>(classService.getRandomHouses(), HttpStatus.OK);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<List<ExistingHouseDTO>> getUserHouses(@RequestParam Long userId){
		return new ResponseEntity<>(classService.getUserHouses(userId), HttpStatus.OK);
	}
	
	@PostMapping("/findBy")
	public ResponseEntity<List<ExistingHouseDTO>> getHousesByFilter(@RequestBody List<FilterDTO> filters){
		return new ResponseEntity<>(classService.findByFilters(filters), HttpStatus.OK); 
	}

}
