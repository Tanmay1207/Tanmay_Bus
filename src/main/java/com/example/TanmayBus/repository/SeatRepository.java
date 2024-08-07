
package com.example.TanmayBus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import com.example.TanmayBus.model.Seat;
import org.springframework.stereotype.Repository;
public interface SeatRepository extends JpaRepository<Seat, Long> {
  List<Seat> findByBooked(boolean b);
  List<Seat> findByBusNameAndBooked(String busName, boolean booked);
  boolean existsByBusNameAndSeatNumberAndBooked(String busName, Integer seatNumber, boolean b);
  List<Seat> findByBusName(String busName);
List<Seat> findByBusNameAndBookingDate(String busName, LocalDate date);
boolean existsByBusNameAndSeatNumberAndBookedAndBookingDate(String busName, Integer seatNumber, boolean b,
		LocalDate bookingDate);
 
}
