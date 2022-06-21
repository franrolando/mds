package com.mdsbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseId;

public interface IHouseRepository extends JpaRepository<House, HouseId> {

	List<House> findByUserId(Long userId);
	
}
