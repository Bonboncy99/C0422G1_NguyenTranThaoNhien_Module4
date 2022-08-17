package com.example.model;

public class Vehicle {
    private int id;
    private String vehicle;

    public Vehicle() {
    }

    public Vehicle(int id, String vehicle) {
        this.id = id;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return  vehicle;
    }
}
