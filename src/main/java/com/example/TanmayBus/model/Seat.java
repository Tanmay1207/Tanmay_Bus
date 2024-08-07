package com.example.TanmayBus.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "seats_tbl")
public class Seat {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "seat_number")
   private int seatNumber;
   @Column(name = "booked")
   private boolean booked;
   @Column(name = "bus_name")
   private String busName;
   @Column(name = "booking_date")
   private LocalDate bookingDate;
   public Seat() {
   }
   public Seat(int seatNumber, String busName, LocalDate bookingDate) {
       this.seatNumber = seatNumber;
       this.booked = false;
       this.busName = busName;
       this.bookingDate = bookingDate;
   }
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public int getSeatNumber() {
       return seatNumber;
   }
   public void setSeatNumber(int seatNumber) {
       this.seatNumber = seatNumber;
   }
   public boolean isBooked() {
       return booked;
   }
   public void setBooked(boolean booked) {
       this.booked = booked;
   }
   public String getBusName() {
       return busName;
   }
   public void setBusName(String busName) {
       this.busName = busName;
   }
   public LocalDate getBookingDate() {
       return bookingDate;
   }
   public void setBookingDate(LocalDate bookingDate) {
       this.bookingDate = bookingDate;
   }
}


