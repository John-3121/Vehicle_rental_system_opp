package src;
public class Car extends Vehicle{
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