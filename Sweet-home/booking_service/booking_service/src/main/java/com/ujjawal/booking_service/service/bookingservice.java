package com.ujjawal.booking_service.service;

import com.ujjawal.booking_service.entity.BookingInfoEntity;

public interface bookingservice {
    BookingInfoEntity bookRoom(BookingInfoEntity bookingInfo);
  //  public void processPayment(Long bookingId, PaymentDetails paymentDetails);
}
