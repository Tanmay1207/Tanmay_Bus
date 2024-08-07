
package com.example.TanmayBus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FromToDateController {


   @GetMapping("/from-to-date")
   public String showFromToDatePage() {
       return "from_to_date"; // Return the name of the HTML template for the from_to_date page
   }


   @PostMapping("/buses")
   public String searchBuses() {
       // Perform search or processing logic here
       return "redirect:/buses"; // Redirect to the buses page after form submission
   }
}
