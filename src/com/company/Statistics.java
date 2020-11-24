package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.sql.*;

import java.util.ArrayList;

public class Statistics {
    PreparedStatement pullFromOrders;
    PreparedStatement insertIntoStat;
    PreparedStatement joinAndGetPrice;


    public Statistics() throws SQLException {
        prepareStms();
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
