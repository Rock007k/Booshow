package com.app.services;

import com.app.request.TicketRequest;
import com.app.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse bookTicket(TicketRequest ticketRequest);
    boolean cancelTicket(int userId,String seatId);
    List<String> getUserTickets(int userId);
}
