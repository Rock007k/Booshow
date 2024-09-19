package com.app.controller;

import com.app.entity.Movie;
import com.app.request.MovieRequest;
import com.app.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;


	// admin can new movie
	@PostMapping("/addNew")
	public ResponseEntity<String> postMethodName(@RequestBody Movie movie){

		return movieService.saveMovie(movie) ? new ResponseEntity<String>("Movie added", HttpStatus.OK) :
				new ResponseEntity<String>("Movie not saved",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//delete previous movies
	@DeleteMapping("/deletemovie/{id}")
	public ResponseEntity<Movie> deleteMethodName(@PathVariable int id){
		return new ResponseEntity<>(movieService.removeMovie(id),HttpStatus.OK);
	}
	//update previous movie
	@PutMapping("/updateMovie")
	public ResponseEntity<Movie> updateMethodName(@RequestBody Movie movie){
		return new ResponseEntity<>(movieService.updateMovie(movie.getId(),movie),HttpStatus.OK);
	}
	//get the list of the movies
	@GetMapping("/getMovies")
	public ResponseEntity<List<Movie>> getAllMovie(){
		List<Movie> ls = movieService.getMovies();
		return new ResponseEntity<>(ls,HttpStatus.OK);
	}
	//get a particular movie by id
	@GetMapping("/getMovies/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable int id){
		Optional<Movie> _movie = movieService.getMovieById(id);
		if(_movie.isPresent()){
			return new ResponseEntity<>(_movie.get(),HttpStatus.OK);
		}else {
			throw new NoSuchElementException("Record not found");
		}
	}
}
