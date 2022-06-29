package com.mdsbooking.filter;

public class FilterFactory {

	public static Filter getFilter(String filter) {
		Filter newFilter = null;
		switch (filter.toUpperCase()) {
		case "COMODITY":
			newFilter = new ComodityFilter();
			break;
		case "ZONE":
			newFilter = new ZoneFilter();
			break;
		case "MIN_PRICE":
			newFilter = new MinPriceFilter();
			break;
		case "MAX_PRICE":
			newFilter = new MaxPriceFilter();
			break;
		}
		return newFilter;
	}

}
