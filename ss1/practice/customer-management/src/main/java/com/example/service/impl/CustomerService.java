package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        this.customerRepository.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        this.customerRepository.update(id,customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.delete(id);
    }

    @Override
    public Customer findByID(int id) {
        return this.customerRepository.findByID(id);
    }
}
