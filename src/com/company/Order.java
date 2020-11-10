package com.company;

// Made by Nicolai Orbe. Det er ikke det bedste stykke arbejde, men kunne ikke finde ud af det :)

import java.util.ArrayList;

public class Order {
    static int numOfOrders = 0;
    final int orderNumber;
    ArrayList<Pizza> pizzaList;
    final int pickup;


    public Order(ArrayList<Pizza> pizzaList, int pickup) {
        numOfOrders++;
        orderNumber = numOfOrders;
        this.pizzaList = pizzaList;
        this.pickup = pickup;
    }

    public double calcPrice() {
        double result = 0.0;
        for (Pizza pizza : pizzaList) {
            for (Addons a : pizza.addonList) {
                result = result + a.getPrice();
            }
            result = result + pizza.price;
        }
        return result;
    }

    @Override
    public String toString() {
        return "\nOrder number = " + orderNumber +
                "\nPizzas = " + pizzasToString(pizzaList) +
                "\nPickup = " + pickup +
                "\nTotal price = " + calcPrice();
    }

    private String pizzasToString(ArrayList<Pizza> pizzas){
        String str = "";
        for(Pizza p : pizzas){
            String pizStr = p.name;
            String addons = "";
            for(Addons a : p.addonList){
                addons = addons + " + " + a.getName();
            }
            pizStr = pizStr + addons + "\n";
            str = str + "\n\t" + pizStr;
        }
        return str;
    }
}


