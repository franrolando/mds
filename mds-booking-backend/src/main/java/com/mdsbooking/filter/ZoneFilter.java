package com.mdsbooking.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mdsbooking.model.House;
import com.mdsbooking.model.Zone;

public class ZoneFilter implements Filter {

	@Override
	public Predicate addFilterToHouse(CriteriaBuilder cb,Root root, String value) {
		Join<House, Zone> joinComodities = root.join("zone");
		return cb.equal(cb.upper(joinComodities.<String> get("name")), value.toUpperCase());
	}

}
