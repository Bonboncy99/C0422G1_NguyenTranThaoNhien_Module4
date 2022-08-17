package com.example.model;

public class Year {
    private String year;

    public Year(String year) {
        this.year = year;
    }

    public Year() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year;
    }
}
