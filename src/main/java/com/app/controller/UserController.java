package com.app.controller;


import com.app.entity.Movie;
import com.app.request.UserRequest;
import com.app.services.TicketService;
import com.app.services.MovieService;
import com.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private MovieService movieService;

    @Autowired
    private UserServices userServices;

//    @Autowired
//    private TicketService hallTicketService;

    //user can see all the listed movies
//    @GetMapping("/getMovies")
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        List<Movie> ls = movieService.getMovies();
//        return new ResponseEntity<>(ls, HttpStatus.OK);
//    }
//    //user can book a ticket of the movie or show
//    @PostMapping("/bookTicket/{id}/{seatId}")
//    public ResponseEntity<Boolean> bookTicket(@PathVariable("id") int userId,@PathVariable("seatId") String seatNo){
//        return hallTicketService.bookTicket(userId,seatNo) ? new ResponseEntity<>(true,HttpStatus.OK):
//                new ResponseEntity<>(false,HttpStatus.IM_USED);
//    }
//    //user can see his booked tickets
//    @PostMapping("/getTickets/{id}")
//    public ResponseEntity<List<String>> getTickets(@PathVariable("id") int userId){
//        return new ResponseEntity<>(hallTicketService.getUserTickets(userId),HttpStatus.OK);
//    }
//    //user can cancel his ticket
//    @DeleteMapping("/cancelTicket/{id}/{seatNo}")
//    public ResponseEntity<Boolean> cancelTicket(@PathVariable("id") int userId,@PathVariable("seatNo") String seatNo){
//        return new ResponseEntity<>(hallTicketService.cancelTicket(userId,seatNo),HttpStatus.OK);
//    }
    @PostMapping("/addNew")
    public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest){
        try {
            String result = userServices.saveUser(userRequest);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        } catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
