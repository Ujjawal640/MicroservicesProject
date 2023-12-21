// InvalidPaymentModeException.java
package com.ujjawal.booking_service.exceptions;

public class InvalidPaymentModeException extends RuntimeException {
    public InvalidPaymentModeException() {
        super("Invalid mode of payment");
    }
}
