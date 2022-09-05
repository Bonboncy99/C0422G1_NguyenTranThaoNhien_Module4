package com.codegym.service;

import com.codegym.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();
    void add(Phone phone);
    void update(Phone phone);
    void delete(int id);
    void findById(int id);

}
