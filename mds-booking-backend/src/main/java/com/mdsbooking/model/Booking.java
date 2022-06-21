package com.mdsbooking.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
	@EmbeddedId
	private BookingId id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String name;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "house_id", referencedColumnName = "id"),
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	@MapsId("house_id")
	private House house;

	public BookingId getId() {
		return id;
	}

	public void setId(BookingId id) {
		this.id = id;
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
