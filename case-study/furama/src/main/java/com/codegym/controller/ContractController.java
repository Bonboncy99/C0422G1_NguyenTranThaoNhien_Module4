package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contract")
@Controller
public class ContractController {
    @GetMapping("/")
    public String goToServiceList() {
        return "contract/list";
    }

    @GetMapping("/add")
    public String goToServiceAdd() {
        return "contract/add";
    }

    @GetMapping("/update")
    public String goToServiceUpdate() {
        return "contract/update";
    }
}
