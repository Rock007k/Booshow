package com.app.convertor;

import com.app.entity.Movie;
import com.app.request.MovieRequest;

public class MovieConvertor {
    public static Movie movieDtoToMovie(MovieRequest movieRequest){
        Movie movie = Movie.builder()
                .movieName(movieRequest.getMovieName())
                .duration(movieRequest.getDuration())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .releaseDate(movieRequest.getReleaseDate())
                .rating(movieRequest.getRating())
                .build();
        return movie;
    }
}
