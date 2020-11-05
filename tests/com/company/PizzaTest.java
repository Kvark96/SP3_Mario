package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
	Pizza pep = new Pizza(60.0, "Pepperoni");
	Pizza none = new Pizza(0.0, "");


	@Test
	public void testPrice(){
		assertEquals(60.0, pep.price);
		assertEquals(0.0, none.price);
	}


	@Test
	public void testName(){
		assertEquals("Pepperoni", pep.Name);
		assertEquals("", none.Name);
	}
}