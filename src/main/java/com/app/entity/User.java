package com.app.entity;

import com.app.enums.Gender;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private Integer age;
    private String address;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String mobileNo;

    @Column(unique = true)
    private String emailId;

    private String password;

    private String roles;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

}
