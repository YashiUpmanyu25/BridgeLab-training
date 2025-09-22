// File: RentalDemo.java
import java.util.*;

interface Rentable {
    double calculateRent(int days);
}

abstract class Vehicle {
    protected String plate;
    protected String model;
    protected int capacity; // protected for subclasses
    private boolean available = true;

    public Vehicle(String plate, String model, int capacity) {
        this.plate = plate;
        this.model = model;
        this.capacity = capacity;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean v) { this.available = v; }

    public abstract void display(); // polymorphic hook
}

class Bike extends Vehicle implements Rentable {
    private double dailyRate;

    public Bike(String plate, String model, int capacity, double dailyRate) {
        super(plate, model, capacity);
        this.dailyRate = dailyRate;
    }

    public double calculateRent(int days) {
        // simple operator usage: base * days, small discount for long rentals
        double total = dailyRate * days;
        if (days >= 7) total *= 0.9; // 10% long-rent discount
        return total;
    }

    public void display() {
        System.out.println("Bike: " + model + " (" + plate + ")");
    }
}

class Car extends Vehicle implements Rentable {
    private double base;
    private double perKmRate;
    private double estimatedKm;

    public Car(String plate, String model, int capacity, double base, double perKmRate, double estKm) {
        super(plate, model, capacity);
        this.base = base;
        this.perKmRate = perKmRate;
        this.estimatedKm = estKm;
    }

    public double calculateRent(int days) {
        // combines base daily rate and estimated distance
        return (base * days) + (perKmRate * estimatedKm);
    }

    public void display() {
        System.out.println("Car: " + model + " (" + plate + ")");
    }
}

class Truck extends Vehicle implements Rentable {
    private double tonRate;

    public Truck(String plate, String model, int capacity, double tonRate) {
        super(plate, model, capacity);
        this.tonRate = tonRate;
    }

    public double calculateRent(int days) {
        // surcharge for trucks
        double rent = tonRate * days;
        rent += 200 * days; // fixed surcharge per day
        return rent;
    }

    public void display() {
        System.out.println("Truck: " + model + " (" + plate + ")");
    }
}

class Customer {
    private String name;
    private String phone;
    private List<Rentable> rented = new ArrayList<>();

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void rentVehicle(Rentable r, int days) {
        rented.add(r);
        System.out.printf("%s rented for %d days, cost=₹%.2f%n", name, days, r.calculateRent(days));
    }
}

public class RentalDemo {
    public static void main(String[] args) {
        Bike b = new Bike("MH12AB1111", "Yamaha MT", 2, 400);
        Car c = new Car("MH12XY2222", "Hyundai Creta", 5, 1200, 8.5, 100);
        Truck t = new Truck("MH12TR3333", "Tata ACE", 2, 3000);

        Customer cust = new Customer("Karan", "9876543210");
        cust.rentVehicle(b, 3);
        cust.rentVehicle(c, 2);
        cust.rentVehicle(t, 1);
    }
}
