package com.app.convertor;

import com.app.entity.Show;
import com.app.entity.Ticket;
import com.app.response.TicketResponse;

public class TicketConvertor {
    public static TicketResponse returnTicket(Show show, Ticket ticket){
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();
        return ticketResponseDto;
    }
}
