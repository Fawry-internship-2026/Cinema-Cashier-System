package com.example.Cinema.Ticket.Reservation.App.repository;

import com.example.Cinema.Ticket.Reservation.App.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
    boolean existsByDate(java.time.LocalDate date);
}
