package com.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "THEATERS")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String address;

    @OneToMany(mappedBy = "theater" ,cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "theater" ,cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

}
