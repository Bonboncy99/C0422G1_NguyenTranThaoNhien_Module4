package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurentcyConvertController {

    @Autowired
    private IConvertService iConvertService;


    @GetMapping("/")
    public String greeting(){
        return "/home";
    }

    @GetMapping("/convert")
    public  String convert(@RequestParam String money, @RequestParam String rate, Model model){
        if (model.equals("") ||rate.equals("")){
            model.addAttribute("mess","Không dược để trống");
        } else {
            double money1 = Double.parseDouble(money);
            double rate1 = Double.parseDouble(rate);
            double result = this.iConvertService.convert(money1, rate1);
            model.addAttribute("result", result);
            model.addAttribute("money", money);
            model.addAttribute("rate", rate);
        }
        return "/home";
    }


}
