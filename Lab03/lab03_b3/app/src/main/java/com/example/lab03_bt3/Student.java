package com.example.lab03_bt3;

public class Student {
    private String _id;
    private String _name;
    private String _class;

    public Student(String _id, String _name, String _class) {
        this._id = _id;
        this._name = _name;
        this._class = _class;
    }

    public Student() {

    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getSClass() {
        return _class;
    }

    public void setMark(String _class) {
        this._class = _class;
    }
}