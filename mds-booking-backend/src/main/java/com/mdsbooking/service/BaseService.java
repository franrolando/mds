package com.mdsbooking.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public class BaseService<T extends JpaRepository> {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected T classRepository;
	
	@Autowired
	protected ModelMapper modelMapper;

	public T getClassRepository() {
		return classRepository;
	}

	public void setClassRepository(T classRepository) {
		this.classRepository = classRepository;
	}

}
