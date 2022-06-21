package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InquiryId implements Serializable {

	private HouseIdFK houseFKId;
	@Column(name = "id")
	private Long inquiryId;


	public HouseIdFK getHouseFKId() {
		return houseFKId;
	}

	public void setHouseFKId(HouseIdFK houseFKId) {
		this.houseFKId = houseFKId;
	}

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

}
