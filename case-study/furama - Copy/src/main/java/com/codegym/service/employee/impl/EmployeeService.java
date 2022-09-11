package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }

    @Override
    public void add(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        this.iEmployeeRepository.save(employee);

    }

    @Override
    public void delete(int id) {
        this.iEmployeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }
}
