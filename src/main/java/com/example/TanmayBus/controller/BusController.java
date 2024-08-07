
package com.example.TanmayBus.controller;


import com.example.TanmayBus.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.TanmayBus.model.Bus;
import com.example.TanmayBus.repository.BusRepository;
import com.example.TanmayBus.repository.SeatRepository;


@Controller
public class BusController {


   @Autowired
   private BusRepository busRepository;
   private SeatRepository seatRepository;


   @GetMapping("/buses")
   public String showBuses(Model model, @RequestParam(required = false) String filter) {
       Iterable<Bus> buses;
       if (filter != null) {
           buses = busRepository.findByBusType(filter);
       } else {
           buses = busRepository.findAll();
       }
       model.addAttribute("buses", buses);
       return "bus_list";
   }


   @PostMapping("/addBus")
   public String addBus(@RequestParam String busName,
                        @RequestParam double price,
                        @RequestParam String busType) {
       Bus newBus = new Bus(busName, price, busType);
       busRepository.save(newBus);
       return "redirect:/buses";
   }


}
