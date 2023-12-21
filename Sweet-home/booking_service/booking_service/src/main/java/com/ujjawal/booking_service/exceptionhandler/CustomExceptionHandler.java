package com.ujjawal.booking_service.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ujjawal.booking_service.exceptions.InvalidBookingIdException;
import com.ujjawal.booking_service.exceptions.InvalidPaymentModeException;

@ControllerAdvice
public class CustomExceptionHandler {

 @ExceptionHandler({InvalidPaymentModeException.class, InvalidBookingIdException.class})
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public ResponseEntity<String> handleInvalidInput(Exception ex) {
     return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
 }
}

