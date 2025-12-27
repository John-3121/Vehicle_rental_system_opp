package com.example;
public class Bike extends Vehicle{
     int Cc;
    public Bike(int vehicleId, String brand,int Cc,String model,double pricePerDay){
        super(vehicleId,brand,model, pricePerDay);
        this.Cc = Cc;
    }
    @Override 
    display_info(){
        System.out.println("hello");
    }
}
