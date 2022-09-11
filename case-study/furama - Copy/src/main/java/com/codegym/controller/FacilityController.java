package com.codegym.controller;


import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


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
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/addFacility")
    public String add(@ModelAttribute("facilityDto") @Valid FacilityDto facilityDto,
                      BindingResult bindingResult,
                      Model model,
                      RedirectAttributes redirectAttributes) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
            model.addAttribute("facilityDto", facilityDto);
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.iFacilityService.add(facility);
        redirectAttributes.addFlashAttribute("messCreate", "Create Success");
        redirectAttributes.addFlashAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        redirectAttributes.addFlashAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "redirect:/facility";
    }

    @GetMapping("/update")
    public String goToFacilityUpdate(@RequestParam("idUpdate") int idUpdate, Model model) {
        Facility facility = this.iFacilityService.findById(idUpdate);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/updateFacility")
    public String updateFacility(@ModelAttribute("facilityDto") @Valid FacilityDto facilityDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,Model model) {
        facilityDto.validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
            model.addAttribute("facilityDto", facilityDto);
            return "facility/update";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
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

    @GetMapping(value = {"", "/search"})
    public String search(@RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "") String facilityTypeName,
                         @PageableDefault(size = 7) Pageable pageable,
                         Model model) {
        model.addAttribute("facilityList", this.iFacilityService.search(searchName, facilityTypeName, pageable));
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("searchName", searchName);
        model.addAttribute("facilityTypeName", facilityTypeName);
        model.addAttribute("size", pageable.getPageSize());
        return "facility/list";
    }

}
