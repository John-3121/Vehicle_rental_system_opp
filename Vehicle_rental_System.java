import java.util.Scanner;
public class Vehicle_rental_System{
    public void main(String[] args){
        Scanner sn = new Scanner(System.in);
        Car car1 = new Car(1,"Toyota","Vios",2500,5);
        Car car2 = new Car(2,"ferrai","GT",5000,4);
        
        Vehicle[] vehicles = {car1,car2};
        System.out.println("Available_Rentable_Vehicles");
        for(Vehicle ve:vehicles){
            ve.display_info();
        }
        
    }
}