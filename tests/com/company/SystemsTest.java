package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SystemsTest {
    ArrayList<Pizza> lst = new ArrayList<>();
    Order order1 = new Order(lst, 1700);
    Order order2 = new Order(lst, 1800);
    ArrayList<Order> orderList = new ArrayList<>();
    File A = new File("src/Addons.csv");
    File P = new File("src/Pizzaer.csv");

    @Test
    void addOrderTest()
    {
        //Adds Orders correctly
        orderList.add(order1);
        orderList.add(order2);
        assertEquals(2, orderList.size());
    }

    @Test
    void removeOrderTest()
    {
        orderList.add(order1);
        orderList.add(order2);

        //Removes orders and updates correctly
        orderList.remove(0);
        assertEquals(0, orderList.indexOf(order2));

    }

    @Test
    void setupTest()
    {
        assertTrue(P.exists());
        assertTrue(P.length()>0);
        assertTrue(A.exists());
        assertTrue(A.length()>0);
    }
}
