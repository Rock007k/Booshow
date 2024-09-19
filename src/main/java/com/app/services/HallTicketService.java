package com.app.services;

import java.util.List;

public interface HallTicketService {
    boolean bookTicket(int userId,String seatId);
    boolean cancelTicket(int userId,String seatId);
    List<String> getUserTickets(int userId);
}
