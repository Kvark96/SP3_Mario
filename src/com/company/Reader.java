package com.company;

import java.io.*;
import java.util.Scanner;

/// shit work :)

public class Reader {

    public static void main(String[] args) {
        try {
            printPizzaMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPizzaMenu() throws IOException {
        File file = new File("src/Pizzaer.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {

            scanner = new Scanner(line);
            System.out.println(line);
        }
    }

    public static void printAddons() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Addons.csv"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {

            scanner = new Scanner(line);
            System.out.println(line);
        }
    }
}







///// Junk Code -- delete me at somepoint







//        String filename = "Pizzaer.csv";
//        File file = new File(filename);
//        System.out.println(file.length());
//        try {
//            Scanner input = new Scanner(file);
//            while (input.hasNext()) {
//                String data = input.next();
//                System.out.println(data);
//            }
//            input.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }




