package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingId implements Serializable {

	
	private HouseIdFK houseFKId;
	@Column(name = "id")
	private Long bookingId;


	public HouseIdFK getHouseFKId() {
		return houseFKId;
	}

	public void setHouseFKId(HouseIdFK houseFKId) {
		this.houseFKId = houseFKId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

}
