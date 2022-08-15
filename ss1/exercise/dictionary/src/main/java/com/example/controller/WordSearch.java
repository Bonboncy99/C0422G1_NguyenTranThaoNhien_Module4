package com.example.controller;


import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class WordSearch {

    @Autowired
    IDictionaryService iDictionaryService;

    @GetMapping("/search")
    public String seach(@RequestParam String word, Model model){
        String result = this.iDictionaryService.translate(word);
        model.addAttribute("word",word);
        model.addAttribute("result",result);
        return "index";
    }
}
