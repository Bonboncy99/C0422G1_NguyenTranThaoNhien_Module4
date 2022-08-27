package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @GetMapping("/")
    public String goToServiceList() {
        return "customer/list";
    }

    @GetMapping("/add")
    public String goToServiceAdd() {
        return "customer/add";
    }

    @GetMapping("/update")
    public String goToServiceUpdate() {
        return "customer/update";
    }
}
