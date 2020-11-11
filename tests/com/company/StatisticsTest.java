package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatisticsTest {
    static Order o1;
    static Order o2;
    static Statistics statistics = new Statistics();
    @BeforeAll
    static void init() throws IOException {
        Reader.readPizzaMenu();
        Reader.readAddonMenu();
        Pizza p = Reader.pizzaList.get(0);          // Vesuvio
        p.addonList.add(Reader.addonsList.get(10)); // Familie
        ArrayList<Pizza> pLst = new ArrayList<>();
        pLst.add(p);
        o1 = new Order(pLst, 1700);


        Pizza p1 = Reader.pizzaList.get(1);          // Amerikaner
        p1.addonList.add(Reader.addonsList.get(2)); // Bacon
        ArrayList<Pizza> p1Lst = new ArrayList<>();
        p1Lst.add(p1);
        o2 = new Order(p1Lst, 1700);

    }

    @Test
    void getRevenue(){
        assertEquals(0,statistics.getRevenue());
        statistics.addOrderToStat(o1);
        assertEquals(92.0, statistics.getRevenue());
        statistics.addOrderToStat(o2);
        assertEquals(155.0, statistics.getRevenue());
    }

    @Test
    void saveOrder(){
        statistics.saveOrder(o1);
        String testName = java.time.LocalDate.now().toString() + "_statistics.txt";
        File a = new File(testName);
        assertTrue(a.exists());
        assertTrue(a.length() > 0);
    }
}