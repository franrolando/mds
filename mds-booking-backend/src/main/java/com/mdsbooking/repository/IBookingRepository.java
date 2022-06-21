package com.mdsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdsbooking.model.Booking;
import com.mdsbooking.model.BookingId;

public interface IBookingRepository extends JpaRepository<Booking, BookingId> {

}
