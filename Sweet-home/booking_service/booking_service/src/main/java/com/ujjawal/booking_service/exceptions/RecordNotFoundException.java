package com.ujjawal.booking_service.exceptions;

import dto.ErrorResponse;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }

    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(getMessage(), 400);
    }
}
