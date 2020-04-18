package com.example.rentcarapplication;

public class Car {

    private String name;
    private double price;
    private boolean isAvailable;

    public Car(String name, double price, boolean isAvailable){
        this.name=name;
        this.price=price;
        this.isAvailable=isAvailable;
    }

    public String getName(){return name;}

    public void setName(String name) { this.name = name;}

    public double getPrice(){return price;}

    public void setPrice(){this.price = price;}

    public boolean isAvailable(){return isAvailable;}

    public void setAvailable(boolean available){
        isAvailable = available;
    }


}
