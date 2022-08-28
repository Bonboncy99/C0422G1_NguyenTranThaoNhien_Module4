package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer>findAllByCustomerNameContainsAndCustomerType_CustomerTypeNameContainsAndPhoneNumberContainsAndEmailContains(String name, String typeName, String phone, String email, Pageable pageable);
}