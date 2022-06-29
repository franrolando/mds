package com.mdsbooking.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "house")
public class House implements Serializable {

	@EmbeddedId
	private HouseId id;
	private String name;
	private String description;
	private Double price;
	@OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<HouseImage> images;
	@OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Inquiry> inquiries;
	@OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Booking> bookings;
	@ManyToOne
	private Zone zone;
	@OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<HouseComodity> comodities;
	@ManyToOne
	@MapsId("user_id")
	private User user;

	public Set<Inquiry> getInquiries() {
		return inquiries;
	}

	public void setInquiries(Set<Inquiry> inquiries) {
		this.inquiries = inquiries;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public HouseId getId() {
		return id;
	}

	public void setId(HouseId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<HouseImage> getImages() {
		return images;
	}

	public void setImages(Set<HouseImage> images) {
		this.images = images;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Set<HouseComodity> getComodities() {
		return comodities;
	}

	public void setComodities(Set<HouseComodity> comodities) {
		this.comodities = comodities;
	}

	@Override
	public int hashCode() {
		return this.id.getId().intValue() + this.id.getUserId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof House))
			return false;
		if (obj == this)
			return true;

		House rhs = (House) obj;
		return new EqualsBuilder().append(id, rhs.id).isEquals();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
