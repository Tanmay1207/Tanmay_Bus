

package com.example.TanmayBus.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.TanmayBus.model.Seat;
import com.example.TanmayBus.repository.SeatRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Controller
public class SeatController {
   @Autowired
   private SeatRepository seatRepository;
   @PostMapping("/thank-you")
   public String bookSeat(@RequestParam(name = "busName") String busName,
                          @RequestParam(name = "seatNumber") Integer seatNumber,
                          @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
                          Model model) {
       System.out.println("Inside bookSeat method: " + seatNumber);
       if (seatNumber != null) {
           boolean isSeatBooked = seatRepository.existsByBusNameAndSeatNumberAndBookedAndBookingDate(busName, seatNumber, true, bookingDate);
           if (!isSeatBooked) {
               Seat seat = new Seat(seatNumber, busName, bookingDate);
               seat.setBooked(true);
               seatRepository.save(seat);
               return "thank_you";
           } else {
               return "seat_already_booked_error";
           }
       } else {
           return "error";
       }
   }
   @GetMapping("/seat-list")
   public String showSeatListPage(@RequestParam(name = "busName") String busName,
                                  @RequestParam(name = "date") String dateString,
                                  Model model) {
       LocalDate date = LocalDate.parse(dateString);
       List<Seat> allSeats = seatRepository.findByBusNameAndBookingDate(busName, date);
       List<Integer> bookedSeatNumbers = new ArrayList<>();
       for (Seat seat : allSeats) {
           if (seat.isBooked()) {
               bookedSeatNumbers.add(seat.getSeatNumber());
           }
       }
       List<Integer> availableSeatNumbers = new ArrayList<>();
       for (int i = 1; i <= 10; i++) {
           if (!bookedSeatNumbers.contains(i)) {
               availableSeatNumbers.add(i);
           }
       }
       model.addAttribute("availableSeatNumbers", availableSeatNumbers);
       model.addAttribute("busName", busName);
       model.addAttribute("date", date);
       return "seat_list";
   }
}
