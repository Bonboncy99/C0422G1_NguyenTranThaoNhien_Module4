package com.codegym.service.customer.impl;

import com.codegym.model.customer.CustomerType;
import com.codegym.repository.customer.ICustomerTypeRepository;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
@Autowired
private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }

    @Override
    public void addCustomerType(CustomerType customerType) {
        this.iCustomerTypeRepository.save(customerType);
    }

    @Override
    public void updateCustomerType(CustomerType customerType) {
        this.iCustomerTypeRepository.save(customerType);
    }

    @Override
    public void deleteCustomerType(int id) {
        this.iCustomerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(int id) {
        return this.iCustomerTypeRepository.findById(id).orElse(null);
    }
}
