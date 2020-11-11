package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Statistics {

    private ArrayList<Order> soldOrders;

    public Statistics() {
        soldOrders = new ArrayList<>();
    }

    // Adds pizza to hashmap of soldPizzas.
    public void addOrderToStat(Order order) {
        soldOrders.add(order);
    }

    // Calculates the total revenue of pizzas sold.
    public double getRevenue() {
        double result = 0;
        for(Order o : soldOrders){
            result = result + o.calcPrice();
        }
        return result;
    }

    public void saveOrder(Order order) {
        String filename = java.time.LocalDate.now().toString() + "_statistics.txt";
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(order + "\n");
            myWriter.close();
            System.out.println("Successfully saved order.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Order> getSoldOrders() { return soldOrders; }
}
