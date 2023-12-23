package com.ujjawal.booking_service.exceptionhandler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ujjawal.booking_service.exceptions.InvalidPaymentException;
import com.ujjawal.booking_service.exceptions.RecordNotFoundException;

import dto.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {
private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
	
	
@ExceptionHandler(RecordNotFoundException.class)
public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex) {
    ErrorResponse errorResponse = ex.toErrorResponse();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
}
@ExceptionHandler(InvalidPaymentException.class)
public ResponseEntity<ErrorResponse> paymentException(InvalidPaymentException ex) {
    ErrorResponse errorResponse = ex.toErrorResponse();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
}
}

