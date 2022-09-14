package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employeeRest")
@RestController
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping(value = {"","/search"})
    public ResponseEntity<Page<Employee>> findAll(@PageableDefault(5) Pageable pageable,@RequestParam(defaultValue = "") String name ){
        Page<Employee>employeePage = this.iEmployeeService.findAllAndPaging(name,pageable);
        if (employeePage.hasContent()){
            return new ResponseEntity<>(employeePage,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/showUpdate")
    public ResponseEntity<Employee>goformUpdate(@RequestParam int idUpdate){
        Employee employeeUpdate = this.iEmployeeService.findById(idUpdate);
        if (employeeUpdate==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeUpdate,HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody EmployeeDto employeeDto){
        Employee employee =this.iEmployeeService.findById(employeeDto.getEmployeeId());
        if (employee==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setPosition(iPositionService.findById(employeeDto.getPosition()));
        employee.setDivision(iDivisionService.findById(employeeDto.getDivision()));
        employee.setEducationDegree(iEducationDegreeService.findById(employeeDto.getEducationDegree()));
        this.iEmployeeService.update(employee);
        String mess = "Update success";
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
