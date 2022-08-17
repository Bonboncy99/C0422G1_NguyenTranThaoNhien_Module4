package com.example.service.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDaclarationRepository;
import com.example.service.IMedicalDaclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalDaclarationService implements IMedicalDaclarationService {

    @Autowired
    private IMedicalDaclarationRepository iMedicalDaclarationRepository;
    @Override
    public List<MedicalDeclaration> findAll() {
        return this.iMedicalDaclarationRepository.findAll();
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        this.iMedicalDaclarationRepository.add(medicalDeclaration);
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        this.iMedicalDaclarationRepository.update(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return this.iMedicalDaclarationRepository.findById(id);
    }
}
