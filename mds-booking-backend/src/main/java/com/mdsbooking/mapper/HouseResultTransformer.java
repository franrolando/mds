package com.mdsbooking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseId;
import com.mdsbooking.model.Zone;

@Component
public class HouseResultTransformer implements ResultSetExtractor<Set<House>> {

	@Override
	public Set<House> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Set<House> houses = new HashSet<>();
		while (rs.next()) {
			House newHouse = new House();
			newHouse.setId(new HouseId());
			newHouse.getId().setId(rs.getInt("id"));
			newHouse.getId().setUserId(rs.getLong("user_id"));
			newHouse.setName(rs.getString("house_name"));
			newHouse.setDescription(rs.getString("description"));
			newHouse.setZone(new Zone());
			newHouse.getZone().setId(rs.getInt("zone_id"));
			newHouse.getZone().setName(rs.getString("zone_name"));
			houses.add(newHouse);
		}
		return houses;
	}

}

