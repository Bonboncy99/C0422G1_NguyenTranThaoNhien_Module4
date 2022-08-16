package com.codegym.controller;

import com.codegym.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CondimentController {

    @Autowired
    private ICondimentsService iCondimentsService;


    @GetMapping("/")
    public String goToHoIndex(Model model){
        model.addAttribute("condimentList",this.iCondimentsService.findAll());
        return "condiment";
    }

    @PostMapping("/save")
    public String getResult(@RequestParam Optional condiments, Model model){
        System.out.println(condiments);
        if (condiments.isPresent()){
            model.addAttribute("condimentChooseList",condiments);
        } else {
            model.addAttribute("mess","Vui lòng chọn");
        }
        model.addAttribute("condimentList",this.iCondimentsService.findAll());
        return "condiment";
    }
}
