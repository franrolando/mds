package com.mdsbooking.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDTO {

	@JsonProperty(value = "house_id")
	private Integer houseId;
	@JsonProperty(value = "user_id")
	private Long userId;
	@JsonProperty(value = "booking_id")
	private Long bookingId;
	@JsonProperty(value = "start_date")
	private LocalDateTime startDate;
	@JsonProperty(value = "end_date")
	private LocalDateTime endDate;
	private String name;

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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
