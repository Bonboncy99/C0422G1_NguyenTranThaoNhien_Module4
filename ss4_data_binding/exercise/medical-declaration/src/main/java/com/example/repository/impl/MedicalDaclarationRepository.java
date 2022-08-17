package com.example.repository.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDaclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicalDaclarationRepository implements IMedicalDaclarationRepository {
    private static Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();

    static {
        medicalDeclarationMap.put(1, new MedicalDeclaration(1, "Nhiên", "1999", "Nữ",
                "Việt Nam", "123456789", "Tàu bay", "67", "23",
                "23", "11", "2020", "24", "11", "2020",
                "Quảng Trị"));
        medicalDeclarationMap.put(2, new MedicalDeclaration(2, "BON", "2002", "Nam",
                "Trung Quốc", "123456789", "Tàu thuyền", "68", "24",
                "23", "11", "2020", "24", "11", "2020",
                "ĐN"));
        medicalDeclarationMap.put(3, new MedicalDeclaration(3, "CY", "2000", "Khác",
                "Nhật Bản", "123456789", "Ô tô", "69", "25",
                "23", "11", "2020", "24", "11", "2020",
                "QN"));
        medicalDeclarationMap.put(4, new MedicalDeclaration(4, "Wonwoo", "1999", "Nam",
                "Hàn Quốc", "123456789", "Tàu thuyền", "70", "26",
                "23", "11", "2020", "24", "11", "2020",
                "HCM"));
        medicalDeclarationMap.put(5, new MedicalDeclaration(5, "Hobi", "1998", "Nữ",
                "Nga", "123456789", "Tàu bay", "71", "23",
                "27a", "11", "2020", "24", "11", "2020",
                "ĐL"));
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        int id = (int) (Math.random() * 1000);
        medicalDeclaration.setId(id);
        medicalDeclarationMap.put(medicalDeclaration.getId(), medicalDeclaration);
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(medicalDeclaration.getId(), medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationMap.get(id);
    }
}
