package com.mdsbooking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsbooking.dto.BookingDTO;
import com.mdsbooking.model.Booking;
import com.mdsbooking.model.BookingId;
import com.mdsbooking.model.House;
import com.mdsbooking.model.HouseIdFK;
import com.mdsbooking.repository.IBookingRepository;

@Service
@Transactional
public class BookingService extends BaseService<IBookingRepository> {

	@Autowired
	private HouseService houseService;
	
	public BookingDTO save(BookingDTO newBookingDto) {
		log.info("New booking for user {} and house {}", newBookingDto.getUserId(), newBookingDto.getHouseId());
		House house = houseService.findById(newBookingDto.getUserId(), newBookingDto.getHouseId());
		Booking newBooking = modelMapper.map(newBookingDto, Booking.class);
		BookingId bookingId = new BookingId();
		HouseIdFK houseId = new HouseIdFK();
		houseId.setUserId(newBookingDto.getUserId());
		houseId.setHouseId(newBookingDto.getHouseId());
		bookingId.setHouseFKId(houseId);
		bookingId.setBookingId(Integer.toUnsignedLong(house.getBookings().size() + 1));
		newBooking.setId(bookingId);
		newBooking = classRepository.save(newBooking); 
		return modelMapper.map(newBooking, BookingDTO.class);
	}

}
