package com.app.services;

import com.app.entity.HallTicket;
import com.app.repository.HallTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HallTicketSerivceImple implements HallTicketService{

    @Autowired
    private HallTicketRepository hallTicketRepository;

    @Override
    public boolean bookTicket(int userId, String seatId) {
        hallTicketRepository.save(new HallTicket(seatId,true,userId));
        return true;
    }

    @Override
    public boolean cancelTicket(int userId, String seatId) {
        Optional<HallTicket> hallTicket = hallTicketRepository.findBySeatId(seatId);
        hallTicket.ifPresent(ticket -> hallTicketRepository.delete(ticket));

        return true;
    }

    @Override
    public List<String> getUserTickets(int userId) {
        List<HallTicket> tickets = hallTicketRepository.findByUserId(userId);
        return tickets.stream()
                .map(HallTicket::getSeatId)
                .distinct()
                .collect(Collectors.toList());
    }
}
