package com.ujjawal.booking_service.service;

import com.ujjawal.booking_service.entity.BookingInfoEntity;
import com.ujjawal.booking_service.entity.PaymentDetails;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ujjawal.booking_service.repository.bookingrepository;
import org.springframework.stereotype.Service;
import com.ujjawal.booking_service.feign.paymentinterface;


@Service
public class bookingserviceimpl implements bookingservice{

    @Autowired
    private bookingrepository bookingrepositor;
    
    @Autowired
    paymentinterface paymentinterface;


    @Override
    public BookingInfoEntity bookRoom(BookingInfoEntity bookingInfo) {
    	
    	bookingInfo.setRoomNumbers(generateRandomroom(bookingInfo.getNumOfRooms()));
    	
    	bookingInfo.setRoomPrice(1000*(bookingInfo.getNumOfRooms())*calculatedays(bookingInfo.getFromDate(),bookingInfo.getToDate()) );
    	
    	bookingInfo.setTransactionId((long) 0);
    	Date today= new java.util.Date();
    	bookingInfo.setBookedOn( today);
    	
        return bookingrepositor.save(bookingInfo);
    }


	private int calculatedays(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		int daysdiff = 0;
	    long diff = toDate.getTime() - fromDate.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
	    daysdiff = (int) diffDays;
	    return daysdiff;
	}


	private String generateRandomroom(int numOfRooms) {
		// TODO Auto-generated method stub
		Random random = new Random();
        StringBuilder roomNumbers = new StringBuilder();

        for (int i = 0; i < numOfRooms; i++) {
            int roomNumber = random.nextInt(100) + 1;
            roomNumbers.append(roomNumber);

            if (i < numOfRooms - 1) {
                roomNumbers.append(", ");
            }
        }

        return roomNumbers.toString();
	}


	public BookingInfoEntity processPayment(Long bookingId, PaymentDetails paymentDetails) {
		
		Long paymentid=paymentinterface.performTransaction(paymentDetails).getBody();
		
		BookingInfoEntity bookingInfoEntity = bookingrepositor.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
		 
		 bookingInfoEntity.setTransactionId(paymentid);
		 
		 bookingrepositor.save(bookingInfoEntity);

	        return bookingInfoEntity;
		 
		
		// TODO Auto-generated method stub
		
	}
}
