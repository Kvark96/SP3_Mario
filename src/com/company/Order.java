package com.company;

// Made by Nicolai Orbe. Det er ikke det bedste stykke arbejde, men kunne ikke finde ud af det :)

import java.util.ArrayList;

public class Order {
    static int numOfOrders = 0;
    final int orderNumber;
    ArrayList<Pizza> pizzaList;
    final int pickup;


    public Order (ArrayList<Pizza> pizzaList, int pickup) {
       numOfOrders++;
       orderNumber = numOfOrders;
       this.pizzaList = pizzaList;
       this.pickup = pickup;
    }

    public double calcPrice () {
        double result = 0.0;
      for (Pizza pizza : pizzaList) {
        result = result + pizza.price;
      }
        return result;
    }
    public double getPrice(){
        return calcPrice();
    }

  @Override
  public String toString() {
    return "orderNumber = " + orderNumber + ", pizzaList = " + pizzaList + ", pickup = " + pickup;
  }
}


