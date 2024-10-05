package com.app.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String address;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}

