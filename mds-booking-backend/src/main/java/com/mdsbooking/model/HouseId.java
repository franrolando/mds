package com.mdsbooking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Embeddable
public class HouseId implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_id")
	private Long userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return this.id.intValue() + this.userId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HouseId))
            return false;
        if (obj == this)
            return true;

        HouseId rhs = (HouseId) obj;
        return new EqualsBuilder()
            .append(id, rhs.id)
            .append(userId, rhs.userId)
            .isEquals();
	}
	
}
