package com.codegym.repository.impl;

import com.codegym.model.Condiment;
import com.codegym.repository.ICondimentsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CondimentsRepository implements ICondimentsRepository {
    private static  Map<Integer, Condiment> integerCondimentMap  = new HashMap<>();
    static {
        integerCondimentMap.put(1,new Condiment(1,"Lettuce"));
        integerCondimentMap.put(2,new Condiment(2,"Tomato"));
        integerCondimentMap.put(3,new Condiment(3,"Mustard"));
        integerCondimentMap.put(4,new Condiment(4,"Sprouts"));
    }

    @Override
    public List<Condiment> findAll() {
        return new ArrayList<>(integerCondimentMap.values());
    }
}
