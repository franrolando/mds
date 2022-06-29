package com.mdsbooking.filter;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import com.mdsbooking.model.Comodity;
import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseComodity;

public class ComodityFilter implements Filter {

	@Override
	public Predicate addFilterToHouse(CriteriaBuilder cb,Root root, String value) {
		SetJoin<House, Set<HouseComodity>> joinComodities = root.joinSet("comodities");
		Join<HouseComodity, Comodity> joinComodity = joinComodities.join("comodity");
		return cb.equal(cb.upper(joinComodity.<String> get("name")), value.toUpperCase());
	}

}
