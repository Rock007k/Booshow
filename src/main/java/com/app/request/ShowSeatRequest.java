package com.app.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ShowSeatRequest {
    private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
