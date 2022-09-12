package com.codegym.service.employee.impl;

import com.codegym.model.employee.Position;
import com.codegym.repository.employee.IPositionRepository;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return this.iPositionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return this.iPositionRepository.findById(id).orElse(null);
    }
}
