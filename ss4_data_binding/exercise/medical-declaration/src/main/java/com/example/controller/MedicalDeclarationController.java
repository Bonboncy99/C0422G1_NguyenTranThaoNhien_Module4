package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDaclarationService iMedicalDaclarationService;
    @Autowired
    private IDayService iDayService;
    @Autowired
    private IGenderService iGenderService;
    @Autowired
    private IMonthService iMonthService;
    @Autowired
    private INationalityService iNationalityService;
    @Autowired
    private IVehicleService iVehicleService;
    @Autowired
    private IYearService iYearService;

    @GetMapping("/")
    public String goToForm(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        model.addAttribute("genders", this.iGenderService.findAll());
        model.addAttribute("days", this.iDayService.findAll());
        model.addAttribute("months", this.iMonthService.findAll());
        model.addAttribute("years", this.iYearService.findAll());
        model.addAttribute("nationalities", this.iNationalityService.findAll());
        model.addAttribute("vehicles", this.iVehicleService.findAll());
        return "medical_declaration/form_create";
    }

    @GetMapping("/list")
    public String goToList(Model model) {
        model.addAttribute("medicalDeclarationList", this.iMedicalDaclarationService.findAll());
        return "medical_declaration/list";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.iMedicalDaclarationService.add(medicalDeclaration);
        redirectAttributes.addFlashAttribute("messCreate", " Create success");
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String goToUpdateForm(@RequestParam int id, Model model) {
        model.addAttribute("medicalDeclaration", this.iMedicalDaclarationService.findById(id));
        model.addAttribute("genders", this.iGenderService.findAll());
        model.addAttribute("days", this.iDayService.findAll());
        model.addAttribute("months", this.iMonthService.findAll());
        model.addAttribute("years", this.iYearService.findAll());
        model.addAttribute("nationalities", this.iNationalityService.findAll());
        model.addAttribute("vehicles", this.iVehicleService.findAll());
        return "medical_declaration/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.iMedicalDaclarationService.update(medicalDeclaration);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        return "redirect:/list";
    }
}
