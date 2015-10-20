package com.example.alphatabsample;

public class Project {
    private long number;
    private String name;

    public Project(int number, String name) {
        setNumber(number);
        setName(name);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
