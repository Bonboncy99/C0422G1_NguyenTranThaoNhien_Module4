package com.codegym.dto;

import com.codegym.model.customer.CustomerType;

import javax.persistence.*;

public class CustomerSearchDto {
    private Integer customerId;
    private CustomerType customerType;
    private String customerName;
    private String phoneNumber;
    private String email;

    public CustomerSearchDto(Integer customerId, CustomerType customerType, String customerName, String phoneNumber, String email) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
