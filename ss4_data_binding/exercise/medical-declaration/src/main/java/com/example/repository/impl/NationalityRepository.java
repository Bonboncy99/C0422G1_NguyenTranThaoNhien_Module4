package com.example.repository.impl;

import com.example.model.Nationality;
import com.example.repository.INationalityRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NationalityRepository implements INationalityRepository {
    private static Map<Integer,Nationality> integerNationalityMap;
    static {
        integerNationalityMap = new HashMap<>();
        integerNationalityMap.put(1,new Nationality(1,"Việt Nam"));
        integerNationalityMap.put(2,new Nationality(2,"Hàn Quốc"));
        integerNationalityMap.put(3,new Nationality(3,"Trung Quốc"));
        integerNationalityMap.put(4,new Nationality(4,"Nhật Bản"));
        integerNationalityMap.put(5,new Nationality(5,"Nga"));
    }


    @Override
    public List<Nationality> findAll() {
        return new ArrayList<>(integerNationalityMap.values());
    }
}
