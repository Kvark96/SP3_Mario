package com.company;
//author Sebastian Hejlesen
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Reader {

    static List<Pizza> pizzaList = new ArrayList<Pizza>();
    static List<Addons> addonsList = new ArrayList<Addons>();



    public static void readPizzaMenu() throws IOException {
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


    public static void readAddonMenu() throws IOException {
        File file = new File("src/Addons.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        Scanner scanner = null;
        int index = 0;

        try{
            while ((line = reader.readLine()) != null) {
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                Addons addon = new Addons(0, "cheese", 0);
                addonsList.add(addon);
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
            }catch(IOException e){
            System.out.println("Addons file cannot be found.");
            System.out.println(e.getStackTrace());
        }
    }


    public static void printPizzaMenu() {
        System.out.println(pizzaList);
    }

    public static void printaddonslist() {
        System.out.println(addonsList);
    }
}