package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        System.out.println(pizza.getPrice());
        Pizza cheesePizza = new Cheese(pizza);
        System.out.println(cheesePizza.getPrice());
        Pizza cheeseOnionPizza = new Onion(cheesePizza);
        cheeseOnionPizza.print();
        System.out.println(cheeseOnionPizza.getPrice());
    }
}