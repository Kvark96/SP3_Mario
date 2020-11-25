package com.company;
/*
        Written by Oliver Juul Reder
 */
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
	ArrayList<Pizza> pizzas = new ArrayList<>();

	@Test
	void calcPrice() throws SQLException {
		// List has some amount of items
		pizzas.add(new Pizza(0, 60.0, "Pep"));
		pizzas.add(new Pizza(1, 55.0, "Haw"));
		Order order = new Order(pizzas, 1700);
		assertEquals(115, order.calcPrice());
		pizzas.remove(0);
		pizzas.remove(0);

		// List is empty
		assertEquals(0, order.calcPrice());
	}

	@Test
	void testOrderNumber() throws SQLException {
		ArrayList<Pizza> lst = new ArrayList<>();
		Order order1 = new Order(lst, 1700);
		Order order2 = new Order(lst, 1800);
		Order order3 = new Order(lst, 1900);

		// Tests if orderNumber is properly assigned
	}
}