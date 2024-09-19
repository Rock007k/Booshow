package com.app.services;

import com.app.entity.Movie;
import com.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiecImple implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public boolean saveMovie(Movie movie) {
        movieRepository.save(movie);
        return true;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        Optional<Movie> _movie = movieRepository.findById(id);
        return _movie;
    }

    @Override
    public Movie removeMovie(int id) {
        Optional<Movie> _movie = movieRepository.findById(id);
        if(_movie.isPresent()){
            movieRepository.deleteById(id);
        }
        return _movie.get();
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        Optional<Movie> _movie = movieRepository.findById(id);

        if(_movie.isPresent()){
            Movie movie1 = _movie.get();
            movie1.setMovieName(movie.getMovieName());
//            movie1.setDuration(movie.getDuration());
//            movie1.setGenre(movie.getGenre());
//            movie1.setRating(movie.getRating());
//            movie1.setLanguage(movie.);
        }
        return _movie.get();
    }
}
