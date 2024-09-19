package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TICKETS")
public class HallTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String seatId;
    private boolean booked;
    private int userId;

    public HallTicket(String seatId, boolean b, int userId) {
        this.seatId=seatId;
        this.booked=b;
        this.userId=userId;
    }
}
