package com.example;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
  // Main mn = new Main();
 //  public void options(int choice){}
       static Scanner sn = new Scanner(System.in);
    //   static LocalDateTime time= new LocalDateTime().now();
   
    public static void main(String[] args) {
        
     
        boolean exit = false;
        while(!exit){
                 
            System.out.println("=== VEHICLE RENTAL SYSTEM ===\n1. Show all vehicles\n2. Rent a vehicle\n3. Return a vehicle\n4. View rentals\n5. Exit\nEnter choice:");
            
            System.out.println("1.Enter a choice");
                 try{
                     int choice = sn.nextInt(); 
                  switch(choice){
         case 1:
             Car.available_vehicles();
         break;
         case 2:
             System.out.println("Enter id");
               int id =sn.nextInt();            
              System.out.println("Enter you fullname") ;
               String name =sn.nextLine();  
              Customer customer = new Customer(id,fname);  
              int car = sn.nextInt();
                           ArrayList<Car> cars = cr.carList();
                           for(Car c:cars){
                                Rental rn =new Rental(1,Customer,c(car-1),LocalDate.now());
                           }
                                    
             // Rental rn = new Rental(1,,)  ;         
         break;
         case 3:
         break;
         case 4:
         break;
         case 5:
             exit=true;
             System.out.println("Exit sucessfully!");         
            break;                      
                  }                     
                 }catch(Exception e){
                          System.out.println("Invalid");
                 }
                 

        }
    }
   
 
public static void rent_vehicle(){
  
         System.out.println("Choose a car to rent(1,2etc...");
         try{
             int choice =  sn.nextInt();
              
         }catch(Exception e){
              System.out.println("error");    
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
          ArrayList<Car> cars = new ArrayList<Car>();
    private int seats;
          Car(){};
    public Car(int vehicleId, String brand, String model, double pricePerDay, int seats) {
        super(vehicleId, brand, model, pricePerDay);
        this.seats = seats;
    }
          
    @Override
    public void display_info() {
        System.out.println("🚗 Car: " + getBrand() + " " + getModel() + " | Seats: " + seats + " | ₱" + getPricePerDay() + "/day");
    }
    public ArrayList<Car> carList(){return cars;}    
          
public static void available_vehicles(){
          Car car1 = new Car(1,"Toyota","Vios",2500.00,5);
          Car car2 = new Car(2,"ferrai","GT",5000.00,4);
         cars.add(car1);
         cars.add(car2);
          
        int z =1;
        Vehicle[] vehicles = {car1,car2};
        System.out.println("Available_Rentable_Vehicles");
        for(Vehicle ve:vehicles){
            System.out.print(z+++": ");
                 ve.display_info();
        }
  }          
}

class Customer{
    String name;
    int uId;
   public Customer(String name,int uId){
        this.name = name;
        this.uId = uId;
    }
         public String getName(){return name;}
    
}
class Rental{
         Scanner sn =new Scanner(System.in);
       private int rental_id ; 
       private Vehicle vehicle;
       private Customer customer;
       private LocalDate localdate;  
       private int days;  
         
    Rental(int rental_id,Vehicle vehicle,Customer customer,LocalDate localdate){
             this.vehicle=vehicle;
             this.customer=customer ;
             this.rental_id = rental_id;
             this.localdate = localdate;
    }
         int getRentalId(){return rental_id;}
         Vehicle getVehicle(){return vehicle;}
         Customer getCustomer(){return customer;}
         LocalDate getLocalDate(){return localdate;}
         
         public double calculatecost(double days){
               return days * vehicle.getPricePerDay();
         }
         
}


abstract class Vehicle implements Rentable{
    private int vehicleId;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available = true;
    
         Vehicle(){};
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


