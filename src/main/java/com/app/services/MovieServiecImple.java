package com.app.services;

import com.app.convertor.MovieConvertor;
import com.app.entity.Movie;
import com.app.exceptions.MovieAlreadyExist;
import com.app.exceptions.MovieDoesNotExists;
import com.app.repository.MovieRepository;
import com.app.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiecImple implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public String saveMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        if(movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())){
            throw new MovieAlreadyExist();
        }
        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);
        movieRepository.save(movie);
        return "Movie saved";
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
    public String removeMovie(Integer id) {
        Optional<Movie> _movie = movieRepository.findById(id);
        if(_movie.isPresent()){
            movieRepository.deleteById(id);
        }else {
            throw new MovieDoesNotExists();
        }
        return "Movie deleted";
    }



    @Override
    public String updateMovie(Integer id, MovieRequest movieRequest) {
        Optional<Movie> _movie = movieRepository.findById(id);

        if(_movie.isPresent()){
            Movie movie1 = _movie.get();
            movie1.setMovieName(movieRequest.getMovieName());
            movie1.setDuration(movieRequest.getDuration());
            movie1.setGenre(movieRequest.getGenre());
            movie1.setRating(movieRequest.getRating());
            movie1.setLanguage(movieRequest.getLanguage());
        }else {
            throw new MovieDoesNotExists();
        }
        return "Movie Updated successfully";
    }
}
