package com.example.lab2_bai4;

public class Bai4_Employee {
    private String Id;
    private String FullName;
    private boolean isManager;

    public Bai4_Employee(String id, String fullName, boolean isManager) {
        Id = id;
        FullName = fullName;
        this.isManager = isManager;
    }

    public Bai4_Employee() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
