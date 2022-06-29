package com.mdsbooking.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Filter {

	public abstract Predicate addFilterToHouse(CriteriaBuilder cb,Root root, String value);

}
