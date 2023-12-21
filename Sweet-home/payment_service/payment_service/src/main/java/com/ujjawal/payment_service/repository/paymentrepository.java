package com.ujjawal.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujjawal.payment_service.entity.TransactionDetailsEntity;

@Repository
public interface paymentrepository extends JpaRepository<TransactionDetailsEntity,Long>{

}
