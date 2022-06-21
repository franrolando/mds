package com.mdsbooking.dto;

import java.util.Set;

public abstract class HouseDTO<T> {

	private Integer id;
	private String name;
	private String description;
	private ZoneDTO zone;
	private Set<ComodityDTO> comodities;
	private Long userId;
	private Set<T> images;

	public HouseDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<T> getImages() {
		return images;
	}

	public void setImages(Set<T> images) {
		this.images = images;
	}

	public ZoneDTO getZone() {
		return zone;
	}

	public void setZone(ZoneDTO zone) {
		this.zone = zone;
	}

	public Set<ComodityDTO> getComodities() {
		return comodities;
	}

	public void setComodities(Set<ComodityDTO> comodities) {
		this.comodities = comodities;
	}

}
