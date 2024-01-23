package com.ujjawal.booking_service.controller;

import com.ujjawal.booking_service.entity.BookingInfoEntity;
import com.ujjawal.booking_service.entity.PaymentDetails;

import com.ujjawal.booking_service.exceptions.InvalidPaymentModeException;
import com.ujjawal.booking_service.service.bookingservice;
import com.ujjawal.booking_service.service.bookingserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking" )
public class bookingController {
    @Autowired
    private bookingserviceimpl bookingService;

    @PostMapping
    public ResponseEntity<BookingInfoEntity> bookRoom(@RequestBody BookingInfoEntity bookingInfo) {
       BookingInfoEntity bookedRoom = bookingService.bookRoom(bookingInfo);
        return new ResponseEntity<>(bookedRoom, HttpStatus.CREATED);
    }

   @PostMapping("/{bookingId}/transaction")
    public ResponseEntity<BookingInfoEntity> processPayment(@PathVariable Long bookingId, @RequestBody PaymentDetails paymentDetails) {
   
	   BookingInfoEntity BookingInfoEntity= bookingService.processPayment(bookingId, paymentDetails);
           return new ResponseEntity<>(BookingInfoEntity,HttpStatus.CREATED);
  
    }
}
