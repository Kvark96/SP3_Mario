package com.company;

// Written by Tobias Linge 05-11-2020.


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Systems
{
    ArrayList<Order> orderArrayList;
    Statistics statistic;
    User user = new User();
    PreparedStatement removeFromOrders;
    PreparedStatement removeFromOrderID;

    public Systems() throws SQLException {
        orderArrayList = new ArrayList<Order>();
        this.statistic = new Statistics();
        prepareStmts();
        setup();
        run();
    }

    private void setup() throws SQLException {
        Reader.readPizzaID();
        Reader.readPizzaMenu();
    }


    public void addOrder(Order order)
    {
        orderArrayList.add(order);
        updateOrders();
    }

    public  void removeOrder()
    {
        System.out.println("Please enter order number");
        String input = user.takeInput();
        try{
            int in = Integer.parseInt(input);

            try{
                System.out.println("Save order in statistics? y / n");
                if(user.takeInput().startsWith("y")){
                    statistic.saveOrder(in);
                }

                removeFromOrders.setInt(1, in);
                removeFromOrders.executeUpdate();

                removeFromOrderID.setInt(1, in);
                removeFromOrderID.executeUpdate();

            } catch(Exception e){
                System.out.println("Input was not recognized.");
                e.printStackTrace();
            }
        } catch (Exception e){
            System.out.println("Order Number was not recognized.");
            e.printStackTrace();
        }
        updateOrders();
    }

    private void updateOrders(){
        printOrders();
    }


    private void run() throws SQLException {
        System.out.println("Please enter \"new order\", \"remove order\" or \"close\".");
        String input = user.takeInput().toLowerCase();
        switch (input) {
            case "new order":
                addOrder(user.newOrder());
                run();
                break;
            case "remove order":
                removeOrder();
                run();
                break;
            case "close":
                System.out.println("Total revenue is: " + statistic.getRevenue());
                break;
            default:
                System.out.println("Input was not recognized.");
                run();
        }
    }

    private void printOrders(){
        for(Order o : orderArrayList){
            System.out.println(o);
        }
    }

    private void prepareStmts() throws SQLException {
        removeFromOrders = JDBCConnection.prepare(
                "DELETE FROM Orders WHERE OrderID = ?"
        );

        removeFromOrderID = JDBCConnection.prepare(
                "DELETE FROM OrderID WHERE OrderID = ?"
        );
    }
}
