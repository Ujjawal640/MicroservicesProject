package com.ujjawal.booking_service.entity;

public class PaymentDetails {

    private String paymentMode;
    private Long bookingId;
    private String upiId;
    private String cardNumber;

    // Constructors, getters, and setters

    public PaymentDetails() {
        // Default constructor needed for JSON deserialization
    }

    public PaymentDetails(String paymentMode, Long bookingId, String upiId, String cardNumber) {
        this.setPaymentMode(paymentMode);
        this.setBookingId(bookingId);
        this.setUpiId(upiId);
        this.setCardNumber(cardNumber);
    }

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

    // Getters and Setters
}

