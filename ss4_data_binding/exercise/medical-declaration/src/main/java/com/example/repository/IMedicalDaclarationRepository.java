package com.example.repository;
import com.example.model.MedicalDeclaration;
import java.util.List;

public interface IMedicalDaclarationRepository {
    List<MedicalDeclaration>findAll();
    void add(MedicalDeclaration medicalDeclaration);
    void update(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById(int id);
}
