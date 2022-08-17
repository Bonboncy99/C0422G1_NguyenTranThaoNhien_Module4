package com.example.service.impl;

import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;
import com.example.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    private IVehicleRepository iVehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return this.iVehicleRepository.findAll();
    }
}
