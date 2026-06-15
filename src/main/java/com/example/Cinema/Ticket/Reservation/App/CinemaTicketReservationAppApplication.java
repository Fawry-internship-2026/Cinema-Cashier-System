package com.example.Cinema.Ticket.Reservation.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CinemaTicketReservationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaTicketReservationAppApplication.class, args);
	}

}
