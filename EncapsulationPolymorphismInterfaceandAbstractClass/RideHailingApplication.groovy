import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId; this.driverName = driverName; this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.printf("%s - Driver: %s, Rate/km: %.2f%n", vehicleId, driverName, ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String location = "Unknown";
    public Car(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) {
        // example: base + distance*rate
        double base = 50;
        return base + getRatePerKm()*distance;
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { location = newLocation; }
}

class Bike extends Vehicle implements GPS {
    private String location = "Unknown";
    public Bike(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm()*distance; // no base
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { location = newLocation; }
}

class Auto extends Vehicle implements GPS {
    private String location = "Unknown";
    public Auto(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) {
        // slightly higher per km and small base
        double base = 20;
        return base + getRatePerKm()*distance;
    }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { location = newLocation; }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Car car = new Car("CAR-01","Vikram",12.0);
        Bike bike = new Bike("BIKE-01","Soni",6.0);
        Auto auto = new Auto("AUTO-01","Manu",8.0);

        car.updateLocation("MG Road");
        bike.updateLocation("Brigade Road");
        auto.updateLocation("Indiranagar");

        vehicles.add(car); vehicles.add(bike); vehicles.add(auto);

        double distance = 10.5; // kms
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.printf("  Current Location: %s%n", (v instanceof GPS) ? ((GPS)v).getCurrentLocation() : "N/A");
            System.out.printf("  Fare for %.2f km: %.2f%n", distance, v.calculateFare(distance));
            System.out.println("---");
        }
    }
}
