package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
@Autowired
    ICustomerService iCustomerService;

    @GetMapping("/")
    public String goToListCustomer(Model model) {
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }
}
