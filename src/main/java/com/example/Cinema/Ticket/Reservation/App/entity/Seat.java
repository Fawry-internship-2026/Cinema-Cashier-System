package com.example.Cinema.Ticket.Reservation.App.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="seat_row" , nullable = false)
    private Integer row;

    @Column(name ="seat_column" , nullable = false)
    private Integer column;
}
