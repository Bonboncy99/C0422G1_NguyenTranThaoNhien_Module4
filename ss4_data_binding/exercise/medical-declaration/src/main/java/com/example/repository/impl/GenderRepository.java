package com.example.repository.impl;
import com.example.model.Gender;
import com.example.repository.IGenderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenderRepository implements IGenderRepository {
    private static List<Gender>genderList = new ArrayList<>();
    static {
       genderList.add(new Gender("Nam"));
       genderList.add(new Gender("Nữ"));
       genderList.add(new Gender("Khác"));
    }
    @Override
    public List<Gender> findAll() {
        return genderList;
    }
}
