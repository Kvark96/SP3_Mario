package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;

public class Statistics {

    private ArrayList<Order> soldOrders;

    public Statistics() {
        soldOrders = new ArrayList<>();
    }

    // Adds order to soldOrders.
    public void addOrderToStat(Order order) {
        soldOrders.add(order);
    }

    // Calculates the total revenue of pizzas sold.
    public double getRevenue() {
        double result = 0;
        if (soldOrders.size() < 1) return 0;
        for (Order o : soldOrders) {
            result = result + o.calcPrice();
        }
        return result;
    }

    public void saveOrder(int OrderID) throws SQLException {
        PreparedStatement pullFromOrders = JDBCConnection.prepare(
                "SELECT * FROM Orders WHERE OrderID = ?"
        );

        PreparedStatement insertIntoStat = JDBCConnection.prepare(
                "INSERT INTO Statistic(PID, NumberSold) VALUES (?, ?)"
        );


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
}
