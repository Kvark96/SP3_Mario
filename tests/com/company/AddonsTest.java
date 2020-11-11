package com.company;
/*
*   Made by Sebastian Hejlesen
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddonsTest {
	Addons addTest = new Addons(12, "fish", 20.0);
	@Test
	void constructorTest(){
		assertEquals(12, addTest.getId());
		assertEquals("fish", addTest.getName());
		assertEquals(20.0, addTest.getPrice());
	}
}