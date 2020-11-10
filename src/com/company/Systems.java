package com.company;

// Written by Tobias Linge 05-11-2020.


import java.util.ArrayList;

public class Systems
{
    ArrayList<Order> orderArrayList;
    Statistics statistic;


    public Systems() {
        orderArrayList = new ArrayList<Order>();
        this.statistic = new Statistics();
    }


    public void addOrder(Order order)
    {
        orderArrayList.add(order);
    }

    public  void removeOrder(int i)
    {
        orderArrayList.remove(i);
    }

   /* public void addPizza()
    {

    }*/

}
