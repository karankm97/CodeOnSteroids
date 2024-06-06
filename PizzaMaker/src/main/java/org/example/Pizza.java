package org.example;

public class Pizza  {
    String name = "Pizza";
    Integer price = 100;

    public void print() {
        System.out.println(name);
    }

    public Integer getPrice() {
        return this.price;
    }
}
