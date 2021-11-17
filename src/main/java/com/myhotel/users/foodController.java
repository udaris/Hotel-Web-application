package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class foodController {
    @Autowired private FoodService service;

@GetMapping("/food")
    public String showFoods(Model model){
    List <foods> listFoods=service.listAll();
    model.addAttribute("listFoods", listFoods);

    return "food";

}
    @GetMapping("/food/new")
    public String showForm(Model model){
        model.addAttribute("food", new foods());
        //model.addAttribute("pageTitle", "Add New Foods");
        return "food_form";
    }

}
