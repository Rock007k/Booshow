package com.app.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ShowRequest {
    private Time time;
    private Date date;
    private Integer theaterId;
    private Integer movieId;
}
