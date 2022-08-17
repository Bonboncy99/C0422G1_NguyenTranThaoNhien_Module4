package com.example.repository.impl;
import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private static Map<Integer, Vehicle> integerVehicleMap;
    static {
        integerVehicleMap = new HashMap<>();
        integerVehicleMap.put(1,new Vehicle(1,"Tàu bay"));
        integerVehicleMap.put(2,new Vehicle(2,"Tàu Thuyền"));
        integerVehicleMap.put(3,new Vehicle(3,"Ô tô"));
        integerVehicleMap.put(4,new Vehicle(4,"Khác(ghi rõ)"));
    }

    @Override
    public List<Vehicle> findAll() {
        return new ArrayList<>(integerVehicleMap.values());
    }
}
