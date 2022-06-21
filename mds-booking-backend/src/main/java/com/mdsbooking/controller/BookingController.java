package com.mdsbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.BookingDTO;
import com.mdsbooking.service.BookingService;

@RequestMapping("/booking")
@RestController
public class BookingController extends BaseController<BookingService> {

	@PostMapping
	public ResponseEntity<BookingDTO> addNewBooking(@RequestBody BookingDTO newBooking){
		return new ResponseEntity<>(classService.save(newBooking), HttpStatus.CREATED);
	}
	
}
