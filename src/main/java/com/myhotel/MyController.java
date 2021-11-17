package com.myhotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("")
    public String showHomePage(){
        System.out.println("My Hotel System");
        return "index";
    }
}
