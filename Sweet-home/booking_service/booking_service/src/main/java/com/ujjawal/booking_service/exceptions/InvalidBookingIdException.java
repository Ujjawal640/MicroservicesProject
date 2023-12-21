package com.ujjawal.booking_service.exceptions;

public class InvalidBookingIdException extends RuntimeException {
    public InvalidBookingIdException() {
        super(" Invalid Booking Id ");
    }
}