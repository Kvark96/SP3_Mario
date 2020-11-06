package com.company;

// Made by Nicolai Orbe. Det er ikke det bedste stykke arbejde, men kunne ikke finde ud af det :)

//import

public class Order {
    static int numOfOrders = 0;
    private int orderNumber;
    ArrayList<Pizza> pizzaList;
    int pickup = 1930;


    public Order (ArrayList <Pizza> pizzaList, int pickup) {
       numOfOrders ++;
       orderNumber = numOfOrders;
       this.pizzaList = pizzaList;
       this.pickup = pickup;
    }

    public double calcPrice () {
        double result = 0.0;
        for(int i = 0; i < pizzaList; i++){
             result = result + pizza.price;
        }
        return result;
    }
    public double getPrice(){
        return calcPrice();
    }
}


