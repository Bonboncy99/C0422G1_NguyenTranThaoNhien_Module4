package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicPlayerController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/create")
    public String gotoAddForm(Model model){
        model.addAttribute("song",new Song());
        return "add";
    }

    @GetMapping("/")
    public String gotoList(Model model){
        model.addAttribute("songlist",this.iSongService.findAll());
        return "list";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        this.iSongService.add(song);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/  ";
    }

    @GetMapping("/update")
    public String goToUpdate(@RequestParam int id,Model model){
        model.addAttribute("song",this.iSongService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Song song){
        this.iSongService.update(song);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        this.iSongService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model){
        model.addAttribute("song",this.iSongService.findById(id));
        return "detail";
    }
}
