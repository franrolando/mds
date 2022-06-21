package com.mdsbooking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseImageDTO {
	
	@JsonProperty(value = "house_id")
	private Integer houseId;
	@JsonProperty(value = "user_id")
	private Long userId;
	private String url;

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
