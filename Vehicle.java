package com.example;

public abstract class Vehicle implements Rentable{
    private int vehicleId;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available = true;
    
    public Vehicle(int vehicleId, String brand, String model, double pricePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    
    @Override
    public void rent(){
        if (available) {
            available = false;
            System.out.println(brand + " " + model + " has been rented.");
        } else {
            System.out.println(brand + " " + model + " is not available.");
        }
    }
    @Override
    public void return_vehicle(){
        available = true;
        System.out.println(brand + " " + model + " has been returned.");
    }
    
    public abstract void display_info();
    }
    
    