package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/// shit doesnt work.....

public class Reader {

    public static void main(String[] args) {
        String filename = "Pizzaer Mario1.02.csv";
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String data = input.next();
                System.out.println(data);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
