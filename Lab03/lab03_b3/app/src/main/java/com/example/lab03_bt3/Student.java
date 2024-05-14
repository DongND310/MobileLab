package com.example.lab03_bt3;

public class Student {
    private String code;
    private String name;
    private String _class;

    public Student(String code, String name, String _class) {
        this.code = code;
        this.name = name;
        this._class = _class;
    }

    public String get_code() {
        return code;
    }

    public void set_code(String code) {
        this.code = code;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}