package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void add(Customer customer);
    void update(int id,Customer customer);
    void delete(int id);
    Customer findByID(int id);
}
