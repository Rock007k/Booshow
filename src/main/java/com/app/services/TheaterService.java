package com.app.services;

import com.app.request.TheaterRequest;
import com.app.request.TheaterSeatRequest;

public interface TheaterService {
    String saveTheater(TheaterRequest theaterRequest);
    String addTheaterSeat(TheaterSeatRequest theaterSeatRequest);
}
