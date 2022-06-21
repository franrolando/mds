package com.mdsbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdsbooking.model.Inquiry;
import com.mdsbooking.model.InquiryId;

public interface IInquiryRepository extends JpaRepository<Inquiry, InquiryId> {

}
