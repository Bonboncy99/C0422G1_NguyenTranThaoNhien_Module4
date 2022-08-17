package com.codegym.controller;

import com.codegym.model.MailBox;
import com.codegym.service.ILanguageService;
import com.codegym.service.IMailBoxService;
import com.codegym.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ElectronicMailBoxController {

    @Autowired
    private IMailBoxService iMailBoxService;
    @Autowired
    private ILanguageService iLanguageService;

    @Autowired
    private IPageSizeService iPageSizeService;

    @GetMapping("/")
    public String create(Model model) {
        model.addAttribute("mailBox", new MailBox());
        model.addAttribute("languageList", this.iLanguageService.findAll());
        model.addAttribute("pageSizeList", this.iPageSizeService.findAll());
        return "mailbox";
    }

//    @PostMapping("/create")
//    public String addMailBox(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes) {
//        this.iMailBoxService.addMailBox(mailBox);
//        redirectAttributes.addFlashAttribute("mess", "Success");
//        return "redirect:mailbox";
//    }

    @PostMapping("/create")
    public String addMailBox(@ModelAttribute MailBox mailBox, Model model) {
        this.iMailBoxService.addMailBox(mailBox);
        model.addAttribute("mess","success");
        model.addAttribute("mailBox",this.iMailBoxService.view(mailBox.getId()));
        return "detail_mailbox";
    }
}
