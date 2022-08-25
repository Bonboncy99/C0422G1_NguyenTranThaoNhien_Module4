package com.codegym.webmusic.controller;

import com.codegym.webmusic.dto.SongDto;
import com.codegym.webmusic.model.Song;
import com.codegym.webmusic.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
        public String goToList(Model model){
        model.addAttribute("songList",this.iSongService.findAll());
        return "list";
        }

    @GetMapping("/add")
    public String goToAdd(Model model){
        model.addAttribute("songDto",new SongDto());
        return "add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("songDto") @Valid SongDto songDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "add";
        }
                Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        this.iSongService.add(song);
        return "redirect:/";
    }
    @GetMapping("/update")
    public String goToUpdate(@RequestParam int id, Model model){
        model.addAttribute("songDto",iSongService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("songDto") @Valid SongDto songDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        this.iSongService.add(song);
        return "redirect:/";
    }
}
