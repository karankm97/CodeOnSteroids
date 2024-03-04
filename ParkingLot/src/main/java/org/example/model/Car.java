package org.example.model;

public class Car {
    private String regNo;
    private String color;

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    public Car(String regNo, String color) {
        this.regNo = regNo;
        this.color = color;
    }
}
