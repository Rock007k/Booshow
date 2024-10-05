package com.app.services;

import com.app.entity.Movie;
import com.app.request.MovieRequest;

import java.util.List;
import java.util.Optional;

public interface MovieService {
     String saveMovie(MovieRequest movieRequest);
     List<Movie> getMovies();
     Optional<Movie> getMovieById(int id);
     String removeMovie(Integer id);
     String updateMovie(Integer id,MovieRequest movieRequest);
}
