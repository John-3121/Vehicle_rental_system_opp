package com.example;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
  // Main mn = new Main();
 //  public void options(int choice){}
   
    public static void main(String[] args) {
       Scanner sn = new Scanner(System.in);
     
        boolean exit = false;
        while(!exit){
            System.out.println("=== VEHICLE RENTAL SYSTEM ===\n1. Show all vehicles\n2. Rent a vehicle\n3. Return a vehicle\n4. View rentals\n5. Exit\nEnter choice:");
            
            System.out.println("1.Enter a choice");
                 int choice = sn.nextInt();
                  switch(choice){
         case 1:
             available_vehicles();
         break;
         case 2:
         break;
         case 3:
         break;
         case 4:
         break;
                  }
        }
    }
   
 public static void available_vehicles(){
        Car car1 = new Car(1,"Toyota","Vios",2500.00,5);
        Car car2 = new Car(2,"ferrai","GT",5000.00,4);
        
        Vehicle[] vehicles = {car1,car2};
        System.out.println("Available_Rentable_Vehicles");
        for(Vehicle ve:vehicles){
            ve.display_info();
        }
  }
   
}
class Bike extends Vehicle{
     int Cc;
    public Bike(int vehicleId, String brand,int Cc,String model,double pricePerDay){
        super(vehicleId,brand,model, pricePerDay);
        this.Cc = Cc;
    }
    @Override 
   public void display_info(){
        System.out.println("hello");
    }
}


 class Car extends Vehicle{
    private int seats;

    public Car(int vehicleId, String brand, String model, double pricePerDay, int seats) {
        super(vehicleId, brand, model, pricePerDay);
        this.seats = seats;
    }
    @Override
    public void display_info() {
        System.out.println("🚗 Car: " + getBrand() + " " + getModel() + " | Seats: " + seats + " | ₱" + getPricePerDay() + "/day");
    }
}

class Customer{
    String name;
    int uId;
   public Customer(String name,int uId){
        this.name = name;
        this.uId = uId;
    }
    
}
abstract class Vehicle implements Rentable{
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
    
interface Rentable {
    void rent();
    void return_vehicle();
}


