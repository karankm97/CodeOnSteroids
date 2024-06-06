package org.example;

public class Onion extends Pizza {
    Pizza pizza;
    String name = "Onion";

    Integer price = 35;

    public Onion(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void print() {
        System.out.println(name);
        pizza.print();
    }

    @Override
    public Integer getPrice() {
        return price + pizza.getPrice();
    }
}
