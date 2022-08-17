package com.example.model;

public class Month {
    private String month;

    public Month(String month) {
        this.month = month;
    }

    public Month() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return month;
    }
}
