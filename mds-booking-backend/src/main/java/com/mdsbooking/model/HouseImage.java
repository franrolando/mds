package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "house_image")
public class HouseImage implements Serializable {
	@EmbeddedId
	private HouseImageId id;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "house_id", referencedColumnName = "id"),@JoinColumn(name = "user_id", referencedColumnName = "user_id")})
	@MapsId("house_id")
	private House house;

	public HouseImageId getId() {
		return id;
	}

	public void setId(HouseImageId id) {
		this.id = id;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
