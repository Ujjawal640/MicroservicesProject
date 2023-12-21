package com.ujjawal.booking_service.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
@Data
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private Date fromDate;
    private Date toDate;
    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private Long transactionId;
    private Date bookedOn;



}

