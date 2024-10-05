package com.app.services;

import com.app.convertor.TheaterConvertor;
import com.app.entity.Theater;
import com.app.entity.TheaterSeat;
import com.app.enums.SeatType;
import com.app.exceptions.TheaterNotExist;
import com.app.repository.TheaterRepository;
import com.app.request.TheaterRequest;
import com.app.request.TheaterSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImple implements TheaterService{
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public String saveTheater(TheaterRequest theaterRequest) {
        if(theaterRepository.findByAddress(theaterRequest.getAddress())!=null){
            throw new TheaterNotExist();
        }
        Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);
        theaterRepository.save(theater);
        return "Theater added successfully";
    }

    @Override
    public String addTheaterSeat(TheaterSeatRequest theaterSeatRequest) {
        if(theaterRepository.findByAddress(theaterSeatRequest.getAddress())==null){
            throw new TheaterNotExist();
        }

        Integer noOfSeatsInRow = theaterSeatRequest.getNoOfSeatInRow();
        Integer noOfPremiumSeats = theaterSeatRequest.getNoOfPremiumSeat();
        Integer noOfClassicSeat = theaterSeatRequest.getNoOfClassicSeat();
        String address = theaterSeatRequest.getAddress();

        Theater theater = theaterRepository.findByAddress(address);

        List<TheaterSeat> seatList = theater.getTheaterSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for(int i=1;i<=noOfClassicSeat;i++){
            String seatNo = Integer.toString(counter)+ch;

            ch++;
            fill++;
            if(fill == noOfSeatsInRow){
                fill=0;
                counter++;
                ch='A';
            }
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeat.setTheater(theater);
            seatList.add(theaterSeat);
        }

        for(int i=1;i<=noOfPremiumSeats;i++){
            String seatNo = Integer.toString(counter)+ch;

            ch++;
            fill++;
            if(fill==noOfSeatsInRow){
                fill=0;
                counter++;
                ch='A';
            }
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            seatList.add(theaterSeat);
        }
        theaterRepository.save(theater);
        return "Theater Seats have been added successfully";
    }


}
