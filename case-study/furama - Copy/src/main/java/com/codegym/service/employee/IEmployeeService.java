package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee>findAllAndPaging(String name, Pageable pageable);
    List<Employee> findAll();
    void add (Employee employee);
    void update(Employee employee);
    void delete(int id);
    Employee findById(int id);
}
