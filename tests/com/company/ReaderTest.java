package com.company;
/*
        Written by Sebastian Hejlesen
 */
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;


import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {


    File A = new File("src/Addons.csv");
    File P = new File("src/Pizzaer.csv");




    @Test
    void printPizzaMenu() {
        assertTrue(P.exists());
        assertTrue(P.length()>0);


    }

    @Test
    void printAddons() {
        assertTrue(A.exists());
        assertTrue(A.length()>0);

    }
}