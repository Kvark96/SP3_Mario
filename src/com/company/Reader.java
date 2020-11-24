package com.company;
//author Sebastian Hejlesen

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;


public class Reader extends JDBCConnection {


    public static void main(String[] args) throws SQLException {
        int bSize = 30;
        Connection connection = null;

        setup();

        try {


            PreparedStatement statement = con.prepareStatement("INSERT Into PizzaMenu (Name, Ingredients) VALUES(,?,?)");


            File file = new File("src/PizzaMenu.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            Scanner scanner = null;
            int count = 0;


            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                String Name = data[0];
                String Ingredients = data[1];


                statement.setString(1, Name);
                statement.setString(2, Ingredients);

                statement.addBatch();

                if (count % bSize == 0) {
                    statement.executeBatch();
                }
            }
            reader.close();

            statement.executeBatch();
                    con.commit();
                con.close();



        } catch (SQLException | IOException e) {
            System.err.println(e);

        }


    }
}











/*
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            Pizza pizza = new Pizza();
            pizzaList.add(pizza);
            index = 0;
            while (scanner.hasNext()) {

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
*/