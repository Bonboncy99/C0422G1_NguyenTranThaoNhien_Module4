package com.codegym.controller;


import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@RequestMapping("/facility")
@Controller
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/add")
    public String goToFacilityAdd(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/addFacility")
    public String add(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        this.iFacilityService.add(facility);
        redirectAttributes.addFlashAttribute("messCreate", "Create Success");
        redirectAttributes.addFlashAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        redirectAttributes.addFlashAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "redirect:/facility/add";
    }

    @GetMapping("/update")
    public String goToFacilityUpdate(@RequestParam("idUpdate") int idUpdate, Model model) {
        model.addAttribute("facility", this.iFacilityService.findById(idUpdate));
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/updateFacility")
    public String updateFacility(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        this.iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        redirectAttributes.addFlashAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        redirectAttributes.addFlashAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "redirect:/facility  ";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int idDelete) {
        this.iFacilityService.delete(idDelete);
        return "redirect:/facility";
    }

    @GetMapping( value = {"","/search"})
    public String search(@RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "") String facilityTypeName,
                         @PageableDefault(size = 2) Pageable pageable,
                         Model model) {
        model.addAttribute("facilityList",this.iFacilityService.search(searchName,facilityTypeName,pageable));
        model.addAttribute("facilityTypeList",this.iFacilityTypeService.findAll());
        model.addAttribute("searchName", searchName);
        model.addAttribute("facilityTypeName", facilityTypeName);
        model.addAttribute("size", pageable.getPageSize());
        return "facility/list";
    }

}
