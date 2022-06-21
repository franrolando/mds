package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HouseImageId implements Serializable {

	private HouseIdFK houseFKId;
	private String url;

	public HouseIdFK getHouseFKId() {
		return houseFKId;
	}

	public void setHouseFKId(HouseIdFK houseFKId) {
		this.houseFKId = houseFKId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
