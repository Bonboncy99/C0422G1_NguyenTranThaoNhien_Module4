package com.codegym.model;

public class MailBox {
    private int id;
    private String language;
    private int pageSize;
    private boolean spamsFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(int id, String language, int pagesize, boolean spamsFilter, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pagesize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
