package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goToHome() {
        return "index";
    }

    @GetMapping("/calculate")
    public String sendResult(@RequestParam String num1, @RequestParam String num2, @RequestParam String operand, Model model) {
        String result = this.iCalculatorService.calculator(num1, num2, operand);
        model.addAttribute("result", result);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "index";
    }
}
