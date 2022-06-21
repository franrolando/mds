package com.mdsbooking.dto;

import java.util.Set;

public class ExistingHouseDTO extends HouseDTO<HouseImageDTO> {

	private Set<InquiryDTO> inquiries;
	private Set<BookingDTO> bookings;

	public Set<InquiryDTO> getInquiries() {
		return inquiries;
	}

	public void setInquiries(Set<InquiryDTO> inquiries) {
		this.inquiries = inquiries;
	}

	public Set<BookingDTO> getBookings() {
		return bookings;
	}

	public void setBookings(Set<BookingDTO> bookings) {
		this.bookings = bookings;
	}
	
}
