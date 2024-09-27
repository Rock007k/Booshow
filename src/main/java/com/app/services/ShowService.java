package com.app.services;

import com.app.request.ShowRequest;
import com.app.request.ShowSeatRequest;

public interface ShowService {
    String saveShow(ShowRequest showRequest);
    String associateSeats(ShowSeatRequest showSeatRequest);
}
