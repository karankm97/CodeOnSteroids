package org.example;

public class Cheese extends Pizza {
    Pizza pizza;
    Integer price = 30;
    String name = "Cheese";
    public Cheese(Pizza pizza) {
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
