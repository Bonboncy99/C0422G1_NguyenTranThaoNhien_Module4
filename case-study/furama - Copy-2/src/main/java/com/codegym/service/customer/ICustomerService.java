package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer findById (int id);
    Page<Customer>findAllByCustomerNameContainsAndCustomerType_CustomerTypeNameContainsAndPhoneNumberContainsAndEmailContains
            (String name, String typeName, String phone, String email, Pageable pageable);


}