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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping("")
    public String goToServiceList(Model model,@PageableDefault(5) Pageable pageable) {
//        model.addAttribute("employeeList",this.employeeService.findAll(pageable));
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeeList",this.employeeService.findAll());
        model.addAttribute("positionList",this.iPositionService.findAll());
        model.addAttribute("divisionList",this.iDivisionService.findAll());
        model.addAttribute("educationDegreeList",this.iEducationDegreeService.findAll());
        return "employee/list";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","Thêm mới Thành công");
        this.employeeService.add(employee);
        return "redirect:/employee";
    }

}
