package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public void addCustomer(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContainsAndCustomerType_CustomerTypeNameContainsAndPhoneNumberContainsAndEmailContains(String name, String typeName, String phone, String email, Pageable pageable) {
        return this.iCustomerRepository.findAllByCustomerNameContainsAndCustomerType_CustomerTypeNameContainsAndPhoneNumberContainsAndEmailContains(name,typeName,phone,email,pageable);
    }


}
