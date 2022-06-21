package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HouseComoditiesId implements Serializable {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "house_id")
	private Integer houseId;
	@Column(name = "comodity_id")
	private Integer comodityId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getComodityId() {
		return comodityId;
	}

	public void setComodityId(Integer comodityId) {
		this.comodityId = comodityId;
	}

}
