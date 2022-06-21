package com.mdsbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mdsbooking.service.BaseService;

public class BaseController<T extends BaseService> {

	@Autowired
	protected T classService;

	public T getClassService() {
		return classService;
	}

	public void setClassService(T classService) {
		this.classService = classService;
	}

}
