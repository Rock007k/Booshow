package com.app.controller;

import com.app.entity.Movie;
import com.app.request.MovieRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/movie")
public class MovieController {
	// admin can new movie
	@PostMapping("/addNew")
	public ResponseEntity<String> postMethodName(@RequestBody MovieRequest movieRequest){
		//TODO: process POST request
		
	}
	//delete previous movies
	@DeleteMapping("/deletemovie/{id}")
	public ResponseEntity<String> deleteMethodName(@PathVariable int id){

	}
	//update previous movie
	@PutMapping("/updateMovie")
	public ResponseEntity<String> updateMethodName(@RequestBody Movie movie){

	}
	//get the list of the movies
	@GetMapping("/getMovies")
	public ResponseEntity<String> getAllMovie(){

	}
	//get a particular movie by id
	@GetMapping("/getMovies/{id}")
	public ResponseEntity<String> getMovie(@PathVariable int id){

	}
}
