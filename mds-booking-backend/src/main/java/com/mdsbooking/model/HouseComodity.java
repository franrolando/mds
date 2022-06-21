package com.mdsbooking.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "house_comodity")
public class HouseComodity {

	@EmbeddedId
	private HouseComoditiesId id;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "house_id", referencedColumnName = "id"),
		@JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	@MapsId("house_id")
	private House house;
	
	
	@ManyToOne
	@MapsId("comodity_id")
	private Comodity comodity;

	public HouseComoditiesId getId() {
		return id;
	}

	public void setId(HouseComoditiesId id) {
		this.id = id;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Comodity getComodity() {
		return comodity;
	}

	public void setComodity(Comodity comodity) {
		this.comodity = comodity;
	}


}
