package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //user can see all the listed movies
    @GetMapping("/getMovies")
    public ResponseEntity<String> getAllMovies(){

    }
    //user can book a ticket of the movie or show
    @PostMapping("/bookticket")
    public ResponseEntity<String> bookTicket(){

    }
    //user can see his booked tickets
    @GetMapping("/getTickets")
    public ResponseEntity<String> getTickets(){

    }
    //user can cancel his ticket
    @DeleteMapping("/cancelTicket")
    public ResponseEntity<String> cancelTicket(){

    }
}
