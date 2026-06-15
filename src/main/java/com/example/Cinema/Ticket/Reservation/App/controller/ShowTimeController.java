package com.example.Cinema.Ticket.Reservation.App.controller;

import com.example.Cinema.Ticket.Reservation.App.dto.SeatDTO;
import com.example.Cinema.Ticket.Reservation.App.entity.Seat;
import com.example.Cinema.Ticket.Reservation.App.entity.ShowTime;
import com.example.Cinema.Ticket.Reservation.App.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/show-times")
@RequiredArgsConstructor
public class ShowTimeController {
    private final ShowTimeService showTimeService;

    @GetMapping
    public ResponseEntity<List<ShowTime>> getAllShowTimes() {
        return ResponseEntity.ok(showTimeService.getAllShowTimes());
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long id) {
        return ResponseEntity.ok(showTimeService.getAvailableSeats(id));
    }

    @GetMapping("/{id}/seat-map")
    public ResponseEntity<List<SeatDTO>> getSeatMap(@PathVariable Long id) {
        return ResponseEntity.ok(showTimeService.getSeatMap(id));
    }
}
