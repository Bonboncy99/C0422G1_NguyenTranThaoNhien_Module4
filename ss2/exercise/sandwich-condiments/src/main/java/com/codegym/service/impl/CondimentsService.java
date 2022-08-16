package com.codegym.service.impl;

import com.codegym.model.Condiment;
import com.codegym.repository.ICondimentsRepository;
import com.codegym.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {

    @Autowired
    private ICondimentsRepository condimentsRepository;

    @Override
    public List<Condiment> findAll() {
        return this.condimentsRepository.findAll();
    }
}
