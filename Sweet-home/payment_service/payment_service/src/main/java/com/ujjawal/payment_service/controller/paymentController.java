package com.ujjawal.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjawal.payment_service.entity.PaymentDetails;
import com.ujjawal.payment_service.entity.TransactionDetailsEntity;
import com.ujjawal.payment_service.service.paymentserviceimpl;

@RestController
@RequestMapping("/payment")
public class paymentController  {
	
	 @Autowired
	    private paymentserviceimpl paymentService;

	 @PostMapping("/transaction")
	    public ResponseEntity<Long> performTransaction(@RequestBody PaymentDetails paymentDetails) {
	        Long transactionId = paymentService.performTransaction(paymentDetails);
	        return new ResponseEntity<>(transactionId, HttpStatus.CREATED);
	    }

	    @GetMapping("/transaction/{transactionId}")
	    public ResponseEntity<TransactionDetailsEntity> getTransactionDetails(@PathVariable Long transactionId) {
	        TransactionDetailsEntity transactionDetails = paymentService.getTransactionDetails(transactionId);
	        return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
	    }

}
