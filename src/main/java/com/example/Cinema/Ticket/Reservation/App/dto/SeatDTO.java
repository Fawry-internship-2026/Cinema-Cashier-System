package com.example.Cinema.Ticket.Reservation.App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeatDTO {
    private Long id;
    private Integer row;
    private Integer column;
    private boolean available;
}