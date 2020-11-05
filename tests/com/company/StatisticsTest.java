package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsTest {

	Statistics statistics = new Statistics();



	@Test
	void addPizza() {
		statistics.getSoldPizzas().put(0, 1);
		statistics.getSoldPizzas().put(1, 3);
		statistics.getSoldPizzas().put(2, 0);

		// Test 1 : Works when n == 1
		statistics.addPizza(0);
		assertEquals(2, statistics.getSoldPizzas().get(0));

		// Test 2 : Works when n > 1
		statistics.addPizza(1);
		assertEquals(4, statistics.getSoldPizzas().get(1));

		// Test 3 : Works when n == 0
		statistics.addPizza(2);
		assertEquals(1, statistics.getSoldPizzas().get(2));
	}

	@Test
	void calcRevenue() {
		// TODO: Test after implementation of price list.
		statistics.getSoldPizzas().put(0, 1);
		statistics.getSoldPizzas().put(1, 3);
		Pizza pep = new Pizza(55.0, "Pepperoni");
		Pizza haw = new Pizza(60.0, "Hawaii");
		Meny.menu[0] = pep;
		Meny.menu[1] = haw;
		System.out.println("Menu is : " + Meny.menu[0].Name + Meny.menu[1].Name);
		System.out.println("soldPizzas is : " + statistics.getSoldPizzas());
		assertEquals(235.0, statistics.getRevenue());
	}
}