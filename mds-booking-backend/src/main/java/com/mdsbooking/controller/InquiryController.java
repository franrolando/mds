package com.mdsbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdsbooking.dto.InquiryDTO;
import com.mdsbooking.service.InquiryService;

@RequestMapping("/inquiry")
@RestController
public class InquiryController extends BaseController<InquiryService> {

	@PostMapping
	public ResponseEntity<InquiryDTO> addNewInquiry(@RequestBody InquiryDTO inquiry){
		return new ResponseEntity<>(classService.addNewInquiry(inquiry), HttpStatus.CREATED);
	}
	
	
}
