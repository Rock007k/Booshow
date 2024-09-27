package com.app.services;

import com.app.convertor.ShowConvertor;
import com.app.entity.*;
import com.app.enums.SeatType;
import com.app.exceptions.MovieDoesNotExists;
import com.app.exceptions.ShowDoesNotExists;
import com.app.exceptions.TheaterDoesNotExists;
import com.app.repository.MovieRepository;
import com.app.repository.ShowRepository;
import com.app.repository.TheaterRepository;
import com.app.request.ShowRequest;
import com.app.request.ShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShowServiceImple implements ShowService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Override
    public String saveShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtroToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

        if(movieOpt.isEmpty()){
            throw new MovieDoesNotExists();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

        if(theaterOpt.isEmpty()){
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);

        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);
        return "Show has been added successfully";
    }

    @Override
    public String associateSeats(ShowSeatRequest showSeatRequest) {
        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

        if(showOpt.isEmpty()){
            throw new ShowDoesNotExists();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatslist = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(TheaterSeat theaterSeat : theaterSeatslist){
            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
            } else {
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add((showSeat));
        }

        showRepository.save(show);
        return "Show seats have been associated successfully";
    }


}
