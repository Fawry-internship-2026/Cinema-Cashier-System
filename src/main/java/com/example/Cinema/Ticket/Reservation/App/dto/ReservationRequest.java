package com.example.Cinema.Ticket.Reservation.App.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservationRequest {
    private String email;
    private Long showTimeId;
    private Long seatId;
}
