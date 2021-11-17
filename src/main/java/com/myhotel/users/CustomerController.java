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
public class CustomerController {
    @Autowired private CustomerDetails service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers = service.ListAll();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New Customer");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message","The Customer details has benn recorded successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            User user =service.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle", "Edit Customer Details (ID:"+ id + ")");

            return "user_form";
            }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", "The customer has been updated");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id,  RedirectAttributes ra){
        try{
           service.delete(id);
           ra.addFlashAttribute("message", "The customer "+id+" has been deleted");
            return "redirect:/users";

        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }



}
