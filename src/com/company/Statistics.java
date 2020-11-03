package com.company;
/*
    Written by Oliver Juul Reder on the 03. of November, 2020.
*/

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
}
