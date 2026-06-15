package com.example.Cinema.Ticket.Reservation.App.service;

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
public class DatabaseSeeder {

    private final SeatRepository seatRepository;
    private final ShowTimeRepository showTimeRepository;

    @PostConstruct
    public void seedSeats() {
        if (seatRepository.count() == 0) {
            for (int r = 1; r <= 5; r++) {
                for (int c = 1; c <= 5; c++) {
                    Seat seat = new Seat();
                    seat.setRow(r);
                    seat.setColumn(c);
                    seatRepository.save(seat);
                }
            }
            System.out.println("✅ 25 Seats (5x5 Matrix) generated successfully!");
        }
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @PostConstruct
    public void generateDailyShowTimes() {
        LocalDate today = LocalDate.now();
        if (showTimeRepository.existsByDate(today)) return;

        List<LocalTime> times = List.of(LocalTime.of(13, 0), LocalTime.of(16, 0), LocalTime.of(19, 0));
        for (LocalTime time : times) {
            ShowTime showTime = new ShowTime();
            showTime.setDate(today);
            showTime.setTime(time);
            showTimeRepository.save(showTime);
        }
        System.out.println("✅ Daily showtimes generated!");
    }
}