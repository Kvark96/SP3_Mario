package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.sql.*;

import java.util.ArrayList;

public class Statistics {

    private ArrayList<Order> soldOrders;
    PreparedStatement pullFromOrders;
    PreparedStatement insertIntoStat;
    PreparedStatement joinAndGetPrice;


    public Statistics() throws SQLException {
        soldOrders = new ArrayList<>();
        prepareStms();
    }

    // Adds order to soldOrders.
    public void addOrderToStat(Order order) {
        soldOrders.add(order);
    }

    // Calculates the total revenue of pizzas sold.
    public double getRevenue() throws SQLException {
        double result = 0;

        ResultSet prices = joinAndGetPrice.executeQuery();
        while(prices.next()){
            try{
                result += prices.getInt("Price") * prices.getInt("NumberSold");
            } catch(SQLException e){
                System.out.println("Something went wrong while processing the revenue");
                e.printStackTrace();
            }
        }

        return result;

        /*
        double result = 0;
        if (soldOrders.size() < 1) return 0;
        for (Order o : soldOrders) {
            result = result + o.calcPrice();
        }
        return result;
        */
    }

    public void saveOrder(int OrderID) throws SQLException {

        pullFromOrders.setInt(1, OrderID);
        ResultSet rs = pullFromOrders.executeQuery();
        while (rs.next()) {
            try {
                insertIntoStat.setInt(1, rs.getInt(1));
                insertIntoStat.setInt(2, rs.getInt(2) + 1);
                insertIntoStat.executeQuery();
            } catch (SQLException e) {
                System.out.println("Order could not be saved for pizza = " + rs.getInt(1));
            }
        }

        /*
        String filename = java.time.LocalDate.now().toString() + "_statistics.txt";
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(order + "\n");
            myWriter.close();
            System.out.println("Successfully saved order.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
    }

    public ArrayList<Order> getSoldOrders() {
        return soldOrders;
    }

    private void prepareStms() throws SQLException {
        joinAndGetPrice = JDBCConnection.prepare(
                "SELECT * FROM statistic JOIN pizzaID ON PizzaID = PID;"
        );


        pullFromOrders = JDBCConnection.prepare(
                "SELECT * FROM Orders WHERE OrderID = ?"
        );

        insertIntoStat = JDBCConnection.prepare(
                "INSERT INTO Statistic(PID, NumberSold) VALUES (?, ?)"
        );
    }
}
