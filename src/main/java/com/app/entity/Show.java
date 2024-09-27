package com.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SHOWS")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private Time time;

    private Date date;


    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
