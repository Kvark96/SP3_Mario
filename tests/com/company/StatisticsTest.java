package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsTest {

	Statistics statistics = new Statistics();


	@Test
	void addPizza() {
		statistics.getSoldPizzas().put(0, 1);
		statistics.getSoldPizzas().put(1, 3);
		statistics.getSoldPizzas().put(2, 0);

     ArrayList<Pizza> pizzas = new ArrayList<>();
     pizzas.add(new Pizza(0, 20, "l"));
     pizzas.add(new Pizza(1, 20, "j"));
     pizzas.add(new Pizza(2, 20, "k"));

		// Test 1 : Works when n == 1
		statistics.addPizza(pizzas);
		assertEquals(2, statistics.getSoldPizzas().get(0));

		// Test 2 : Works when n > 1
		assertEquals(4, statistics.getSoldPizzas().get(1));

		// Test 3 : Works when n == 0
		assertEquals(1, statistics.getSoldPizzas().get(2));
	}

	@Test
	void calcRevenue() {
		// TODO: Test after implementation of price list.
		statistics.getSoldPizzas().put(0, 1);
		statistics.getSoldPizzas().put(1, 3);
		Pizza pep = new Pizza(14, 55.0, "Pepperoni");
		Pizza haw = new Pizza(15, 60.0, "Hawaii");
		Reader.pizzaList.add(pep);
		Reader.pizzaList.add(haw);
		System.out.println("Menu is : " + Reader.pizzaList.get(0).name + Reader.pizzaList.get(1).name);
		System.out.println("soldPizzas is : " + statistics.getSoldPizzas());
		assertEquals(235.0, statistics.getRevenue());
	}
}