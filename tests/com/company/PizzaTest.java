package com.company;
/*
        Written by Oliver Juul Reder
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
	Pizza pep = new Pizza(14, 60.0, "Pepperoni");
	Pizza none = new Pizza(-1, 0.0, "");


	@Test
	public void testPrice(){
		assertEquals(60.0, pep.price);
		assertEquals(0.0, none.price);
	}


	@Test
	public void testName(){
		assertEquals("Pepperoni", pep.name);
		assertEquals("", none.name);
	}
}