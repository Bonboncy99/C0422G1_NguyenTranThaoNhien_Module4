package com.example.service;
import com.example.model.MedicalDeclaration;
import java.util.List;

public interface IMedicalDaclarationService {
    List<MedicalDeclaration>findAll();
    void add(MedicalDeclaration medicalDeclaration);
    void update(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById(int id);
}
