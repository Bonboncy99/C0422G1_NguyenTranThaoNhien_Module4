package com.codegym.service.employee.impl;

import com.codegym.model.employee.EducationDegree;
import com.codegym.repository.employee.IEducationDegreeRepository;
import com.codegym.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.iEducationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return this.iEducationDegreeRepository.findById(id).orElse(null);
    }
}
