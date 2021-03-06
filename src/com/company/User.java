package com.company;
/*
    Written by Oliver Juul Reder on the 09.11.2020.
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    PreparedStatement insertPizzaIntoOrder;
    PreparedStatement addPickupTimeToOrder;
    PreparedStatement getPizzaNameFromID;
    PreparedStatement currentOrder;
    PreparedStatement removeOrder;
    PreparedStatement createEmptyOrder;

    public User() throws SQLException {
        prepareStmts();
    }

    public String takeInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public Order newOrder() throws SQLException {
        boolean finished = false;
        ArrayList<Pizza> pizzasInOrder = new ArrayList<>();
        int pickupTime = -1;
        createEmptyOrder.execute();
        PreparedStatement getID = JDBCConnection.prepare("SELECT * FROM OrderID ORDER BY OrderID DESC LIMIT 1");
        ResultSet idSet = getID.executeQuery();
        idSet.next();
        int currentOrderID = idSet.getInt("OrderID");

        System.out.println("Enter the new order - type \"add\" and pizza \"number\".");
        while (!finished) {
            String input = takeInput();


            // Add pizza to order
            if (input.startsWith("add")) {
                try {


                    int id = Integer.parseInt(input.substring(4));
                    insertPizzaIntoOrder.setInt(1, currentOrderID);
                    insertPizzaIntoOrder.setInt(2, id);
                    getPizzaNameFromID.setInt(1, id);
                    insertPizzaIntoOrder.executeUpdate();
                    ResultSet pizzaName = getPizzaNameFromID.executeQuery();
                    pizzaName.next();
                    System.out.println("Pizza " + pizzaName.getString("Name") + " was added.");
                    currentOrder.setInt(1, currentOrderID);
                    ResultSet currentPizzas = currentOrder.executeQuery();

                    System.out.println("Order ID is: " + currentOrderID);
                    System.out.println("Current order is: ");
                    while(currentPizzas.next()){
                        System.out.println(currentPizzas.getString("PID"));
                    }

                    System.out.println("Add additional pizzas - type \"add\" and pizza \"number\" or type \"end\" to finish the order." );

                } catch (Exception e) {
                    System.out.println("ID = \"" + input + "\" was not recognized. Please try again.");
                    e.printStackTrace();
                }
            }

            // Remove pizza from order
            if (input.startsWith("remove ")) {
                try {
                    int id = Integer.parseInt(input.substring(7));
                    removeOrder.setInt(1, currentOrderID);
                    removeOrder.setInt(2, id);
                    removeOrder.executeQuery();
                    System.out.println("Pizza " + id + " was removed.");
                } catch (Exception e) {
                    System.out.println("ID = \"" + input + "\" was not recognized. Please try again.");
                }
            }

            // End order selection
            if (input.equals("end")) {
                System.out.println("Enter the pickup time :");
                pickupTime = Integer.parseInt(takeInput());
                addPickupTimeToOrder.setInt(1, currentOrderID);
                addPickupTimeToOrder.setInt(2,pickupTime);
                addPickupTimeToOrder.executeUpdate();
                finished = true;
            }
        }

        return new Order(pizzasInOrder, pickupTime);
    }

    private void prepareStmts() throws SQLException {
        insertPizzaIntoOrder = JDBCConnection.prepare(
                "INSERT INTO Orders (OrderID, PID) VALUES (?,?)"
        );
        addPickupTimeToOrder = JDBCConnection.prepare(
                "UPDATE OrderID SET PickupTime = ? WHERE OrderID = ?"
        );
        getPizzaNameFromID = JDBCConnection.prepare(
                "SELECT Name FROM pizzaMenu WHERE PID = ?"
        );
        currentOrder = JDBCConnection.prepare(
                "SELECT * FROM Orders WHERE OrderID = ?"
        );
        removeOrder = JDBCConnection.prepare(
                "DELETE FROM Orders WHERE OrderID = ? AND PID = ?"
        );

        createEmptyOrder = JDBCConnection.prepare(
                "INSERT INTO OrderID(OrderTime) VALUES (CURRENT_TIMESTAMP)"
        );

    }
}
