package com.codegym.service.impl;

import com.codegym.model.Phone;
import com.codegym.repository.IPhoneRepository;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository iPhoneRepository;
    @Override
    public List<Phone> findAll() {
        return this.iPhoneRepository.findAll();
    }

    @Override
    public void add(Phone phone) {
        this.iPhoneRepository.save(phone);
    }

    @Override
    public void update(Phone phone) {
        this.iPhoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        this.iPhoneRepository.deleteById(id);
    }

    @Override
    public Phone findById(int id) {
        return this.iPhoneRepository.findById(id).orElse(null);
    }
}
