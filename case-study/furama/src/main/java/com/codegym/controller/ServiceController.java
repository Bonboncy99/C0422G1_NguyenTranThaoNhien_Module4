package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/service")
@Controller
public class ServiceController {
    @GetMapping("")
    public String goToServiceList() {
        return "service/list";
    }

    @GetMapping("/add")
    public String goToServiceAdd() {
        return "service/add";
    }

    @GetMapping("/update")
    public String goToServiceUpdate() {
        return "service/update";
    }
}
