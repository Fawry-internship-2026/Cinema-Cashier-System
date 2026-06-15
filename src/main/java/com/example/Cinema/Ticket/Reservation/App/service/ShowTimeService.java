package com.example.Cinema.Ticket.Reservation.App.service;

import com.example.Cinema.Ticket.Reservation.App.dto.SeatDTO;
import com.example.Cinema.Ticket.Reservation.App.entity.Seat;
import com.example.Cinema.Ticket.Reservation.App.entity.ShowTime;
import com.example.Cinema.Ticket.Reservation.App.repository.SeatRepository;
import com.example.Cinema.Ticket.Reservation.App.repository.ShowTimeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeService {
    private final ShowTimeRepository showTimeRepository;
    private final SeatRepository seatRepository;

    public List<ShowTime> getAllShowTimes() {
        return showTimeRepository.findAll();
    }

    public List<Seat> getAvailableSeats(Long showTimeId) {
        return seatRepository.findAvailableSeatsByShowTimeId(showTimeId);
    }
    public List<SeatDTO> getSeatMap(Long showTimeId) {
        List<Seat> allSeats = seatRepository.findAll();
        List<Seat> availableSeats = seatRepository.findAvailableSeatsByShowTimeId(showTimeId);

        return allSeats.stream().map(seat -> {
            boolean isAvail = availableSeats.stream().anyMatch(a -> a.getId().equals(seat.getId()));
            return new SeatDTO(seat.getId(), seat.getRow(), seat.getColumn(), isAvail);
        }).toList();
    }
}
