package com.app.repository;

import com.app.entity.HallTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallTicketRepository extends JpaRepository<HallTicket,Integer> {
        Optional<HallTicket> findBySeatId(String seatNo);
        List<HallTicket> findByUserId(int userId);
}
