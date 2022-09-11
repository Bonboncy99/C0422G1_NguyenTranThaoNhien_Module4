package com.codegym.controller;

import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("")
    public String goToServiceList(Model model,
                                  @PageableDefault(5) Pageable pageable) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeePage",this.iEmployeeService.findAll(pageable));
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList",this.iDivisionService.findAll());
        model.addAttribute("educationDegreeList",this.iEducationDegreeService.findAll());
        return "employee/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("employee") Employee employee,
                      RedirectAttributes redirectAttributes){
        this.iEmployeeService.add(employee);
        redirectAttributes.addFlashAttribute("mess","Create Success");
        return "redirect:/employee";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int idDelete,RedirectAttributes redirectAttributes){
       this.iEmployeeService.delete(idDelete);
       redirectAttributes.addFlashAttribute("mess","Delete Succes");
       return "redirect:/employee";
    }
}
