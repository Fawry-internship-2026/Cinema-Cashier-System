package com.example.Cinema.Ticket.Reservation.App.controller;

import com.example.Cinema.Ticket.Reservation.App.dto.ReservationRequest;
import com.example.Cinema.Ticket.Reservation.App.entity.Reservation;
import com.example.Cinema.Ticket.Reservation.App.service.ReservationService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> bookSet(@Valid @RequestBody ReservationRequest request) {
        try {
            Reservation reservation = reservationService.bookSeat(
                    request.getEmail(),
                    request.getShowTimeId(),
                    request.getSeatId()
            );
            Map<String, Object> response = new HashMap<>();
            response.put("status", "Success");
            response.put("message", "Seat booked successfully");
            response.put("reservationId", reservation.getId());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long id) {
        try {
            reservationService.cancelReservation(id);
            return ResponseEntity.ok("Seat canceled successfully");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
