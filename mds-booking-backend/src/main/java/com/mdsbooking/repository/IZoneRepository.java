package com.mdsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdsbooking.model.Zone;

@Repository
public interface IZoneRepository extends JpaRepository<Zone, Long> {

}
