package com.example.lab2_bai7;

public class Employee {
    private String id;
    private String fullName;
    private boolean isManager;
    public Employee() {
    }

    public Employee(String id, String fullName, boolean isManager) {
        this.id = id;
        this.fullName = fullName;
        this.isManager = isManager;
    }

    public String getId() {
        return id;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isManager() {
        return isManager;
    }
}