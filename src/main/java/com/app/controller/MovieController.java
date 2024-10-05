package com.app.controller;

import com.app.entity.Movie;
import com.app.exceptions.MovieDoesNotExists;
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
	public ResponseEntity<String> postMethodName(@RequestBody MovieRequest movieRequest){
		try {
			String result = movieService.saveMovie(movieRequest);
			return new ResponseEntity<>(result,HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}


	//delete previous movies
	@DeleteMapping("/deleteMovie/{id}")
	public ResponseEntity<String> deleteMethodName(@PathVariable Integer id){
		try {
			String result = movieService.removeMovie(id);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}



	//update previous movie
	@PutMapping("/updateMovie/{id}")
	public ResponseEntity<String> updateMethodName(@RequestBody MovieRequest movieRequest, @PathVariable("id") Integer id){
		try {
			String result = movieService.updateMovie(id,movieRequest);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
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
			throw  new MovieDoesNotExists();
		}
	}
}
