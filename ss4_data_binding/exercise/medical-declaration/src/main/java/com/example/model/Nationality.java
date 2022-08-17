package com.example.model;

public class Nationality {
    private int id;
    private String nationality;

    public Nationality() {
    }

    public Nationality(int id, String nationality) {
        this.id = id;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return nationality;
    }
}
