package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<Integer, Integer> soldPizzas;
    private Map<Integer, Integer> soldAddons;
    public Statistics() {
        soldAddons = new HashMap<>();
        soldPizzas = new HashMap<>();
    }

    // Adds pizza to hashmap of soldPizzas.
    public void addPizza(ArrayList<Pizza> pizzas) {
        for (Pizza p : pizzas) {
            int pIndex = p.id;
            if (soldPizzas.containsKey(pIndex)) {
                soldPizzas.put(pIndex, soldPizzas.get(pIndex) + 1);
            } else {
                soldPizzas.put(pIndex, 1);
            }
            for(Addons a : p.addonList){
                int aIndex = a.getId();
                if(soldAddons.containsKey(aIndex)){
                    soldAddons.put(aIndex, soldAddons.get(aIndex) + 1);
                } else {
                    soldAddons.put(aIndex, 1);
                }
            }
        }
    }

    // Calculates the total revenue of pizzas sold.
    public double getRevenue() {
        double result = 0;
        for (int i = 0; i < Reader.pizzaList.size(); i++) {
            if (soldPizzas.containsKey(i)) {
                result = result + soldPizzas.get(i) * Reader.pizzaList.get(i).getPrice();
            }
        }
        for(int j = 0; j < Reader.addonsList.size(); j++){
            if(soldAddons.containsKey(j)){
                result = result + soldAddons.get(j) * Reader.addonsList.get(j).getPrice();
            }
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

    public Map<Integer, Integer> getSoldPizzas() {
        return soldPizzas;
    }
}
