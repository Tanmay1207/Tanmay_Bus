package com.example.TanmayBus.model;
import jakarta.persistence.*;


@Entity
@Table(name = "buses")
public class Bus {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @Column(name = "bus_name")
   private String busName;


   @Column(name = "price")
   private double price;


   @Column(name = "bus_type")
   private String busType;




   public Bus() {
   }


   public Bus(String busName, double price, String busType) {
       this.busName = busName;
       this.price = price;
       this.busType = busType;
   }




   public Long getId() {
       return id;
   }


   public void setId(Long id) {
       this.id = id;
   }


   public String getBusName() {
       return busName;
   }


   public void setBusName(String busName) {
       this.busName = busName;
   }


   public double getPrice() {
       return price;
   }


   public void setPrice(double price) {
       this.price = price;
   }


   public String getBusType() {
       return busType;
   }


   public void setBusType(String busType) {
       this.busType = busType;
   }
}
