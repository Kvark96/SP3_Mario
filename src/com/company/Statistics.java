package com.company;
/*
    Written by Oliver Juul Reder on the 03.11.2020.
*/

import java.sql.*;

public class Statistics {
    PreparedStatement pullFromOrders;
    PreparedStatement insertIntoStat;
    PreparedStatement countNumberOfPID;
    PreparedStatement getPriceFromID;


    public Statistics() throws SQLException {
        prepareStms();
    }


    // Calculates the total revenue of pizzas sold.
    public double getRevenue() throws SQLException {
        double result = 0;

        for(int i = 1; i < 31; i++){
            try {
                countNumberOfPID.setInt(1, i);

                ResultSet numberOfPizzas = countNumberOfPID.executeQuery();
                numberOfPizzas.next();

                getPriceFromID.setInt(1, i);
                ResultSet priceOfPizza = getPriceFromID.executeQuery();
                priceOfPizza.next();

                result += priceOfPizza.getInt("Price") * numberOfPizzas.getInt(1);
            } catch (SQLException e){
                System.out.println("Something went wrong while finding the revenue");
                e.printStackTrace();
            }
        }

        return result;
    }

    public void saveOrder(int OrderID) throws SQLException {
        pullFromOrders.setInt(1, OrderID);
        ResultSet order = pullFromOrders.executeQuery();
        while(order.next()){
            insertIntoStat.setInt(1, OrderID);
            insertIntoStat.setInt(2, order.getInt("PID"));
            insertIntoStat.executeUpdate();
        }
    }

    private void prepareStms() throws SQLException {
        countNumberOfPID = JDBCConnection.prepare(
                "SELECT COUNT(*) FROM Statistic WHERE PID = ?"
        );


        getPriceFromID = JDBCConnection.prepare(
                "SELECT Price FROM pizzaID WHERE PID = ?"
        );

        pullFromOrders = JDBCConnection.prepare(
                "SELECT * FROM Orders WHERE OrderID = ?"
        );

        insertIntoStat = JDBCConnection.prepare(
                "INSERT INTO Statistic(OrderID, PID) VALUES (?, ?)"
        );
    }
}
