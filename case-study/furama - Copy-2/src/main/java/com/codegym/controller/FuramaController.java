package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuramaController {
    @GetMapping("/")
    public String goToHome(){
        return "home";
    }
}
