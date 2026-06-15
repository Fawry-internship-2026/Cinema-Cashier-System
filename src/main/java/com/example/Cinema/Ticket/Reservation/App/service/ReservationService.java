package com.example.Cinema.Ticket.Reservation.App.service;

import com.example.Cinema.Ticket.Reservation.App.repository.*;
import com.example.Cinema.Ticket.Reservation.App.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final ShowTimeRepository showTimeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Reservation bookSeat(String email, Long showTimeId, Long seatId) {
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    return userRepository.save(newUser);
                });
        ShowTime showTime = showTimeRepository.findById(showTimeId)
                .orElseThrow(() -> new RuntimeException("ShotTime not found"));
        Seat seat = seatRepository.findByIdForUpdate(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        boolean isBooked = reservationRepository
                .existsByShowTimeIdAndSeatIdAndDeletedAtIsNull(showTimeId, seatId);
        if (isBooked) {
            throw new RuntimeException("Sorry , this seat is already booked!");
        }
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setShowTime(showTime);
        reservation.setSeat(seat);
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setDeletedAt(LocalDateTime.now());
        reservationRepository.save(reservation);
    }

}
