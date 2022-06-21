package com.mdsbooking.dto;

import java.io.Serializable;

public class FilterDTO implements Serializable {

	private String name;
	private String value;
	
	public FilterDTO(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
