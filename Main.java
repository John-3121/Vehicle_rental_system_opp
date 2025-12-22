package src;

package src;
// VehicleRentalSystem.java

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

interface Rentable {
    void rent();
    void returnVehicle();
}

// Abstract parent class
abstract class Vehicle implements Rentable {
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
    public void rent() {
        if (available) {
            available = false;
            System.out.println(brand + " " + model + " has been rented.");
        } else {
            System.out.println(brand + " " + model + " is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        available = true;
        System.out.println(brand + " " + model + " has been returned.");
    }

    // Polymorphic method — overridden by subclasses
    public abstract void displayInfo();
}

// Car class inherits from Vehicle
class Car extends Vehicle {
    private int seats;

    public Car(int vehicleId, String brand, String model, double pricePerDay, int seats) {
        super(vehicleId, brand, model, pricePerDay);
        this.seats = seats;
    }

    @Override
    public void displayInfo() {
        System.out.println("🚗 Car: " + getBrand() + " " + getModel() + " | Seats: " + seats + " | ₱" + getPricePerDay() + "/day");
    }
}

// Bike class inherits from Vehicle
class Bike extends Vehicle {
    private int engineCC;

    public Bike(int vehicleId, String brand, String model, double pricePerDay, int engineCC) {
        super(vehicleId, brand, model, pricePerDay);
        this.engineCC = engineCC;
    }

    @Override
    public void displayInfo() {
        System.out.println("🏍️ Bike: " + getBrand() + " " + getModel() + " | " + engineCC + "cc | ₱" + getPricePerDay() + "/day");
    }
}

// Customer class
class Customer {
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getName() { return name; }
}

// Rental class (Composition: has a Customer and a Vehicle)
class Rental {
    private int rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(int rentalId, Customer customer, Vehicle vehicle, LocalDate startDate) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
    }

    public void endRental(LocalDate endDate) {
        this.endDate = endDate;
        vehicle.returnVehicle();
    }

    public double calculateCost() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return days * vehicle.getPricePerDay();
    }

    public void displaySummary() {
        System.out.println("\nRental ID: " + rentalId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel());
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + (endDate != null ? endDate : "Ongoing"));
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create vehicles
        Car car1 = new Car(1, "Toyota", "Vios", 2500, 5);
        Bike bike1 = new Bike(2, "Honda", "Click 125", 800, 125);

        // Store in array (Polymorphism)
        Vehicle[] vehicles = { car1, bike1 };

        System.out.println("=== Available Vehicles ===");
        for (Vehicle v : vehicles) {
            v.displayInfo(); // Polymorphic call
        }

        // Create customer and rent a car
        Customer customer = new Customer(1, "John Doe");
        car1.rent();

        // Create rental record
        Rental rental = new Rental(1, customer, car1, LocalDate.now().minusDays(3));

        // End rental
        rental.endRental(LocalDate.now());

        // Display summary
        rental.displaySummary();
        System.out.println("Total Cost: ₱" + rental.calculateCost());
    }
}