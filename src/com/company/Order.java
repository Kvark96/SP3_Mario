package com.company;

// Made by Nicolai Orbe.

import java.sql.*;
import java.util.ArrayList;

public class Order {
    PreparedStatement addPriceToOrderID;
    PreparedStatement getPizzaPrices;
    PreparedStatement getPizzaList;


    public Order(ArrayList<Pizza> pizzaList, int pickup) throws SQLException {
        prepareStmts();
    }

    public int calcPrice() throws SQLException {
        int totalPrice = 0;

        // Gets current orderId
        PreparedStatement getID = JDBCConnection.prepare("SELECT * FROM OrderID ORDER BY OrderID DESC LIMIT 1");
        ResultSet idSet = getID.executeQuery();
        idSet.next();
        int currentOrderID = idSet.getInt("OrderID");

        // Finds pizzas in current order
        getPizzaList.setInt(1, currentOrderID);
        ResultSet pizzaList = getPizzaList.executeQuery();
        while(pizzaList.next()){
            getPizzaPrices.setInt(1, pizzaList.getInt("PID"));
            ResultSet priceList = getPizzaPrices.executeQuery();
            priceList.next();
            totalPrice += priceList.getInt("Price");
        }
        return totalPrice;



        /*double result = 0.0;
        for (Pizza pizza : pizzaList) {
            for (Addons a : pizza.addonList) {
                result = result + a.getPrice();
            }
            result = result + pizza.price;
        }
        return result;*/
    }

    @Override
    public String toString() {
        try {
            // Gets current orderId
            PreparedStatement getID = JDBCConnection.prepare("SELECT * FROM OrderID ORDER BY OrderID DESC LIMIT 1");
            ResultSet idSet = getID.executeQuery();
            idSet.next();
            int currentOrderID = idSet.getInt("OrderID");
            return "Order Number = " + currentOrderID +
                    "\nTotal price = " + calcPrice();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "";
        }
    }

    /*private String pizzasToString(ArrayList<Pizza> pizzas){
        String str = "";
        for(Pizza p : pizzas){
            String pizStr = p.name;
            String addons = "";
            for(Addons a : p.addonList){
                addons = addons + " + " + a.getName();
            }
            pizStr = pizStr + addons + "\n";
            str = str + "\n\t" + pizStr;
        }
        return str;
    }*/
    private void prepareStmts() throws SQLException {
        addPriceToOrderID = JDBCConnection.prepare(
                "UPDATE OrderID SET Price = ? WHERE OrderID = ?"
        );
        getPizzaPrices = JDBCConnection.prepare(
                "SELECT Price FROM PizzaID WHERE PID = ?"
        );

        getPizzaList = JDBCConnection.prepare(
                "SELECT PID FROM Orders WHERE OrderID = ?"
        );
    }

}


