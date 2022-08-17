package com.example.repository;
import com.example.model.Vehicle;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
}
