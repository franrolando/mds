package com.mdsbooking.filter;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MaxPriceFilter implements Filter {

	@Override
	public Predicate addFilterToHouse(CriteriaBuilder cb, Root root, String value) {
		return cb.lessThanOrEqualTo(root.get("price"), new BigDecimal(value));
	}

}
