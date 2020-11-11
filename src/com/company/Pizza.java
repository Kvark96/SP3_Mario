package com.company;
//author Sebastian Hejlesen
import java.io.PipedInputStream;
import java.util.ArrayList;

public class Pizza {

    int id;
    double price;
    String name;
    ArrayList<Addons> addonList = new ArrayList<>();

    public Pizza(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString(){
        return "\nID="+getId()+",   Pizza: "+getName()+", Price="+getPrice();
    }



    public Pizza() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

