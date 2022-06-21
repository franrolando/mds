package com.mdsbooking.filter;

import com.mdsbooking.model.House;

public interface Filter {

	public abstract void addFilterToHouse(House house, String value);

}
