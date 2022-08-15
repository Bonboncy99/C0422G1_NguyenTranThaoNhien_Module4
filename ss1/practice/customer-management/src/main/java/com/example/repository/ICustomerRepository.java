package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void add(Customer customer);
    void update(int id,Customer customer);
    void delete(int id);
    Customer findByID(int id);
}
