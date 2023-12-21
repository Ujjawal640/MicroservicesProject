package com.ujjawal.payment_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjawal.payment_service.entity.PaymentDetails;
import com.ujjawal.payment_service.entity.TransactionDetailsEntity;
import com.ujjawal.payment_service.repository.paymentrepository;
@Service
public class paymentserviceimpl implements paymentservice {
	
	@Autowired
	private paymentrepository paymentrepository; 

	public Long performTransaction(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub
		TransactionDetailsEntity transactionDetails = new TransactionDetailsEntity() ;
		transactionDetails.setBookingId(paymentDetails.getBookingId());
		transactionDetails.setCardNumber(paymentDetails.getCardNumber());
		transactionDetails.setPaymentMode(paymentDetails.getPaymentMode());
		transactionDetails.setUpiId(paymentDetails.getUpiId());
		TransactionDetailsEntity  EntitySaved=paymentrepository.save(transactionDetails);
		Long id=EntitySaved.getTransactionId();
		return id;
	}

	public TransactionDetailsEntity getTransactionDetails(Long transactionId) {
		// TODO Auto-generated method stub
        Optional<TransactionDetailsEntity> detailsEntityOptional = paymentrepository.findById(transactionId);
		 return detailsEntityOptional.get();
	}

}
