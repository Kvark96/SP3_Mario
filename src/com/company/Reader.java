package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// author Sebastian Hejlesen



public class Reader {

    List<Pizza> pizzaList = new ArrayList<Pizza>();
    List<Addons> addonsList = new ArrayList<Addons>();


   // public static void main(String[] args) {


       // try {
//            readPizzaMenu(pizzaList);
//            readAddonMenu(addonsList);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printPizzaMenu(pizzaList);
//        printaddonslist(addonsList);
//
//    }


    public static void addPizzaToOrder(int id, String order, List<Pizza> pizzaList) {
        for (Pizza p : pizzaList) {
            if (p.id == id) {
                System.out.println(p);
                //add pizza to order
                return;
            }
        }
    }


    public static void readPizzaMenu(List<Pizza> pizzaList) throws IOException {
        File file = new File("src/Pizzaer.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            Pizza pizza = new Pizza();
            pizzaList.add(pizza);
            index = 0;
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {
                    pizza.setId((Integer.parseInt(data)));
                } else if (index == 1) {
                    pizza.setName(data);
                } else if (index == 2) {
                    pizza.setPrice(Double.parseDouble(data));
                } else {
                    System.out.println("invalid data::" + data);
                }
                index++;
            }
        }

    }


    public static void readAddonMenu(List<Addons> addonList) throws IOException {
        File file = new File("src/Addons.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            Addons addon = new Addons(0, "cheese", 0);
            addonList.add(addon);
            index = 0;
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {
                    addon.setId((Integer.parseInt(data)));
                } else if (index == 1) {
                    addon.setName(data);
                } else if (index == 2) {
                    addon.setPrice(Double.parseDouble(data));
                } else {
                    System.out.println("invalid data::" + data);
                }
                index++;
            }
        }
    }


    public static void printPizzaMenu(List<Pizza> pizzalist) {

        System.out.println(pizzalist);
    }

    public static void printaddonslist(List<Addons> addonList) {
        System.out.println(addonList);
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




