package com.ujjawal.booking_service.exceptions;

import dto.ErrorResponse;

public class InvalidPaymentException extends RuntimeException{
	public InvalidPaymentException(String message) {
        super(message);
    }

    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(getMessage(), 400);
    }
}
