package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;


import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {


    File A = new File("src/Addons.csv");
    File P = new File("src/Pizzaer.csv");


    @Test
    void readPizzaMenu() {
        assertTrue(P.exists());
        assertTrue(P.length() > 0);
    }

    @Test
    void readAddonMenu() {

        assertTrue(A.exists());
        assertTrue(A.length() > 0);
    }
}

