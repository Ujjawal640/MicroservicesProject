package com.ujjawal.booking_service.repository;

import com.ujjawal.booking_service.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingrepository extends JpaRepository<BookingInfoEntity,Long> {
}
