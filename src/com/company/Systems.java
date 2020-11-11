package com.company;

// Written by Tobias Linge 05-11-2020.


import java.io.IOException;
import java.util.ArrayList;

public class Systems
{
    ArrayList<Order> orderArrayList;
    Statistics statistic;
    User user = new User();

    public Systems() {
        orderArrayList = new ArrayList<Order>();
        this.statistic = new Statistics();
        setup();
        run();
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
            int del = -1;
            for(int n = 0; n < orderArrayList.size(); n++){
                if(in == orderArrayList.get(n).orderNumber){
                    del = n;
                }
            }
            try{
                System.out.println("Save order in statistics? y / n");
                if(user.takeInput().toLowerCase().startsWith("y")){
                    statistic.saveOrder(orderArrayList.get(del));
                    statistic.addOrderToStat(orderArrayList.get(del));
                    orderArrayList.remove(del);
                } else {
                    orderArrayList.remove(del);
                }
            } catch(Exception e){
                System.out.println("Input was not recognized.");
            }
        } catch (Exception e){
            System.out.println("Order Number was not recognized.");
        }
        updateOrders();
    }

    private void updateOrders(){
        Reader.printPizzaMenu();
        Reader.printaddonslist();
        printOrders();
    }

    private void setup(){
        try {
            Reader.readAddonMenu();
            Reader.readPizzaMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader.printPizzaMenu();
        Reader.printaddonslist();
    }


    private void run(){
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
}
