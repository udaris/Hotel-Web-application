package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RoomsController {
    @Autowired private RoomService service;

    @GetMapping("/rooms")
    public String RoomsDetails(Model model){
        List<Rooms> listrooms = service.listAll();
        model.addAttribute("listrooms", listrooms);
        return "rooms";
    }
    @GetMapping("/rooms/new")
    public String showNew(Model model){
        model.addAttribute("room", new Rooms());
        return "room_form";
    }

    @PostMapping("/rooms/save")
    public String saveRoom(Rooms room, RedirectAttributes re){
        service.save(room);
        re.addFlashAttribute("message","The room details has benn recorded successfully");
        return "redirect:/rooms";
    }

   @GetMapping("/rooms/edit/{id}")
    public String EditRoom(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
       try{
           Rooms room =service.get(id);
           model.addAttribute("room",room);
           model.addAttribute("pageTitle", "Edit room Details (ID:"+ id + ")");

           return "room_form";
       }catch (RoomNotFoundException e){
           ra.addFlashAttribute("message", "The room has been updated");
           return "redirect:/rooms";
       }
   }

    @GetMapping("/rooms/delete/{id}")
    public String showDelete(@PathVariable("id") Integer id,  RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message", "The room "+id+" has been deleted");
            return "redirect:/rooms";

        }catch (RoomNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/rooms";
        }
    }

}
















