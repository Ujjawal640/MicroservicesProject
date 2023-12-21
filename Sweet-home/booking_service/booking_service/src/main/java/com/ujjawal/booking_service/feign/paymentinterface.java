package com.ujjawal.booking_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ujjawal.booking_service.entity.PaymentDetails;

@FeignClient("PAYMENTSERVICE")
public interface paymentinterface {
	
	@PostMapping("/payment/transaction")
    public ResponseEntity<Long> performTransaction(@RequestBody PaymentDetails paymentDetails);

}
