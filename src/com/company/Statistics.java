package com.company;
/*
    Written by Oliver Juul Reder on the 03. of November, 2020.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
	private double revenue;
	private Map<Integer, Integer> soldPizzas;

	public Statistics(){
		revenue = 0.0;
		soldPizzas = new HashMap<>();
	}

	// Adds pizza to hashmap of soldPizzas.
	public void addPizza(int index){
		if(soldPizzas.containsKey(index)){
			soldPizzas.put(index, soldPizzas.get(index) + 1);
		} else {
			soldPizzas.put(index, 1);
		}
	}

	// Calculates the total revenue of pizzas sold.
	public double calcRevenue(){
		double result = 0;
		for(int i = 0; i < Meny.menu.length; i++){
			if(soldPizzas.containsKey(i)){
				result = result + soldPizzas.get(i) * Meny.menu[i].price;
			}
		}
		return result;
	}

/*			This works, we just need Order.java
	public void saveOrder(Order order){
		String filename = java.time.LocalDate.now().toString() + "_statistics.txt";
		try{
			FileWriter myWriter = new FileWriter(filename, true);
			myWriter.write(order + "\n");
			myWriter.close();
			System.out.println("Successfully saved order.");
		} catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
*/
}
