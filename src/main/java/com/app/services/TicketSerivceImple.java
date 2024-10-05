package com.app.services;

import com.app.convertor.TicketConvertor;
import com.app.entity.Show;
import com.app.entity.ShowSeat;
import com.app.entity.Ticket;
import com.app.entity.User;
import com.app.exceptions.SeatsNotAvailable;
import com.app.exceptions.ShowDoesNotExists;
import com.app.exceptions.UserDoesNotExists;
import com.app.repository.ShowRepository;
import com.app.repository.TicketRepository;
import com.app.repository.UserRepository;
import com.app.request.TicketRequest;
import com.app.request.UserRequest;
import com.app.response.TicketResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketSerivceImple implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public TicketResponse bookTicket(TicketRequest ticketRequest) {
        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());

        if(showOpt.isEmpty()){
            throw new ShowDoesNotExists();
        }

        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());

        if(userOpt.isEmpty()){
            throw new UserDoesNotExists();
        }

        User user = userOpt.get();
        Show show = showOpt.get();



        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(),ticketRequest.getRequestSeats());

        if(!isSeatAvailable){
            throw new SeatsNotAvailable();
        }

        Integer getPriceAndAssignSests = getPriceAndAssignSeats(show.getShowSeatList(),ticketRequest.getRequestSeats());

        String seats = listToString(ticketRequest.getRequestSeats());

        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSests);
        ticket.setBookedSeats(seats);
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        return TicketConvertor.returnTicket(show,ticket);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList,List<String> requestSeats){
        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();

            if(requestSeats.contains(seatNo) && !showSeat.getIsAvailable()){
                return false;
            }
        }
        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList,List<String> requestSeats){
        Integer totalAmount =0;
        for(ShowSeat showSeat : showSeatList){

            if(requestSeats.contains(showSeat.getSeatNo())){
                totalAmount+=showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }
        return totalAmount;
    }


    private String listToString(List<String> requestSeats){
        StringBuilder sb = new StringBuilder();

        for(String s : requestSeats){
            sb.append(s).append(",");
        }
        return sb.toString();
    }




    @Override
    public boolean cancelTicket(int userId, String seatId) {
        return false;
    }

    @Override
    public List<String> getUserTickets(int userId) {
        return List.of();
    }
}
