package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {


    File N = new File("src/Addons.csv");



    @Test
    void printPizzaMenu() {
        assertTrue(N.exists());
        assertTrue(N.length()>0);

    }

    @Test
    void printAddons() {
    }
}