package com.mdsbooking.exception;

import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends CustomException {

	public HouseNotFoundException(String error, String reason) {
		super(error, reason, HttpStatus.BAD_REQUEST);
	}


}
