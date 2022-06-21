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
@Table(name = "inquiry")
public class Inquiry implements Serializable {
	@EmbeddedId
	private InquiryId id;
	private String name;
	private LocalDateTime date;
	private String text;
	private String username;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "house_id", referencedColumnName = "id"),
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	@MapsId("house_id")
	private House house;

	public InquiryId getId() {
		return id;
	}

	public void setId(InquiryId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
