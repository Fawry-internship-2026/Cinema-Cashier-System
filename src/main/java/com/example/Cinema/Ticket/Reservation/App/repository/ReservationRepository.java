package com.example.Cinema.Ticket.Reservation.App.repository;

import com.example.Cinema.Ticket.Reservation.App.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByShowTimeIdAndSeatIdAndDeletedAtIsNull(Long showTimeId, Long seatId);
}
