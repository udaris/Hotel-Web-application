package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookingController {
    @Autowired private BookingDetails service;

    @GetMapping("/users/booking")
    public String showBookinglist(Model model){
        List<Bookings> listBookings = service.listAll();
        model.addAttribute("listBookings", listBookings);
        return "booking";
    }
 @GetMapping("/booking/new")
    public String showNew(Model model){
        model.addAttribute("booking", new Bookings());
        return "booking_form";
 }

 @PostMapping("/booking/save")
    public String saveBooking(Bookings bookings){

        service.save(bookings);
        return "redirect:/booking";
 }

}











