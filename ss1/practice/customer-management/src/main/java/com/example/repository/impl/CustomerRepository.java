package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository {
    static Map<Integer,Customer>integerCustomerMap;
    static {
        integerCustomerMap = new HashMap<>();
        integerCustomerMap.put(0, new Customer(0,"T","t@codegym.vn","Da Nang"));
        integerCustomerMap.put(1, new Customer(1,"Nhat","nhat@codegym.vn","Quang Tri"));
        integerCustomerMap.put(2, new Customer(2,"Trang","trang@codegym.vn","Ha Noi"));
        integerCustomerMap.put(3, new Customer(3,"Nguyen Binh Son","son@codegym.vn","Sai Gon"));
        integerCustomerMap.put(4, new Customer(4,"Dang Xuan Hoa","hoadang@codegym.vn","Da Nang"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(integerCustomerMap.values());
    }

    @Override
    public void add(Customer customer) {
        integerCustomerMap.put(customer.getId(), customer);
    }

    @Override
    public void update(int id, Customer customer) {
        integerCustomerMap.put(id,customer);
    }

    @Override
    public void delete(int id) {
        integerCustomerMap.remove(id);
    }

    @Override
    public Customer findByID(int id) {
        return integerCustomerMap.get(id);
    }


}
