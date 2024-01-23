package com.ujjawal.payment_service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="payment")
@Data
public class TransactionDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String paymentMode;
    private Long bookingId;
    private String upiId;
    private String cardNumber;

    // Getters and Setters

}

