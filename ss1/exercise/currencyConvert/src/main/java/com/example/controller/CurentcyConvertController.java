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
    IConvertService iConvertService;


    @GetMapping("/")
    public String greeting(){
        return "/home";
    }

    @GetMapping("/convert")
    public  String convert(@RequestParam String soTienCanDoi, @RequestParam String tiGia, Model model){
        if (soTienCanDoi.equals("") ||tiGia.equals("")){
            model.addAttribute("mess","Không dược để trống");
        } else {
            double soTien1 = Double.parseDouble(soTienCanDoi);
            double tiGia1 = Double.parseDouble(tiGia);
            double ketQua = this.iConvertService.convert(soTien1, tiGia1);
            model.addAttribute("ketQua", ketQua);
            model.addAttribute("soTienCanDoi", soTienCanDoi);
            model.addAttribute("tiGia", tiGia);
        }
        return "/home";
    }


}
