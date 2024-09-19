package com.app.services;

import com.app.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
     boolean saveMovie(Movie movie);
     List<Movie> getMovies();
     Optional<Movie> getMovieById(int id);
     Movie removeMovie(int id);
     Movie updateMovie(int id,Movie movie);
}
