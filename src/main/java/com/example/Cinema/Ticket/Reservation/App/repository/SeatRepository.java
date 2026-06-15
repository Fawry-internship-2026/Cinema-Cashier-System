package com.example.Cinema.Ticket.Reservation.App.repository;

import com.example.Cinema.Ticket.Reservation.App.entity.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat , Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM Seat s WHERE s.id = :id") ///  JPQL
    Optional<Seat> findByIdForUpdate(@Param("id") Long id);

    @Query("SELECT s FROM Seat s WHERE s.id NOT IN " +
            "(SELECT r.seat.id FROM Reservation r WHERE r.showTime.id = :showTimeId AND r.deletedAt IS NULL)")
    List<Seat> findAvailableSeatsByShowTimeId(@Param("showTimeId") Long showTimeId);

}
