package com.codegym.model;

public class PageSize {
    private int id;
    private int size;

    public PageSize(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public PageSize() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size+"";
    }
}
