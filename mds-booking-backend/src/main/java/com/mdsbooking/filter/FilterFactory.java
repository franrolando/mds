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
		case "PRICE":
			newFilter = new PriceFilter();
			break;
		}
		return newFilter;
	}

}
