package com.company;

public class Addons {

int id;
String name;
double price;


    public Addons() {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString(){
        return "\nID="+getId()+",   Addon: "+getName()+", Pris="+getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
