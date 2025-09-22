// File: CabbyGoDemo.java
import java.util.*;

interface IRideService {
    Ride bookRide(String riderId, String vehicleType, double distanceKm);
    void endRide(Ride r);
}

class Vehicle {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public double baseRatePerKm() { // polymorphic override candidate
        return 10.0;
    }
}

class Mini extends Vehicle {
    public Mini(String vehicleNumber, int capacity) { super(vehicleNumber, capacity, "Mini"); }
    @Override public double baseRatePerKm() { return 8.0; }
}

class Sedan extends Vehicle {
    public Sedan(String vehicleNumber, int capacity) { super(vehicleNumber, capacity, "Sedan"); }
    @Override public double baseRatePerKm() { return 12.0; }
}

class SUV extends Vehicle {
    public SUV(String vehicleNumber, int capacity) { super(vehicleNumber, capacity, "SUV"); }
    @Override public double baseRatePerKm() { return 18.0; }
}

class Driver {
    private String name;
    private String license;
    private double rating; // private sensitive

    public Driver(String name, String license, double rating) {
        this.name = name;
        this.license = license;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getRating() { return rating; }
}

class Ride {
    String rideId;
    Vehicle vehicle;
    Driver driver;
    String riderId;
    double distanceKm;
    private double fare; // hide fare

    public Ride(String rideId, Vehicle vehicle, Driver driver, String riderId, double distanceKm) {
        this.rideId = rideId;
        this.vehicle = vehicle;
        this.driver = driver;
        this.riderId = riderId;
        this.distanceKm = distanceKm;
        this.fare = 0.0;
    }

    void setFare(double fare) { this.fare = fare; }
    double getFare() { return fare; }
}

class RideService implements IRideService {
    private Map<String, Driver> drivers = new HashMap<>();
    private int idSeq = 1;

    public void registerDriver(String id, Driver d) { drivers.put(id, d); }

    @Override
    public Ride bookRide(String riderId, String vehicleType, double distanceKm) {
        // naive matching: pick any driver
        Driver d = drivers.values().stream().findFirst().orElse(null);
        if (d == null) return null;
        Vehicle v = switch(vehicleType.toLowerCase()) {
            case "mini" -> new Mini("MH01MIN" + idSeq, 4);
            case "sedan" -> new Sedan("MH01SED" + idSeq, 4);
            case "suv" -> new SUV("MH01SUV" + idSeq, 6);
            default -> new Sedan("MH01DEF" + idSeq, 4);
        };
        Ride ride = new Ride("R" + (idSeq++), v, d, riderId, distanceKm);
        double fare = calculateFare(v, distanceKm);
        ride.setFare(fare);
        System.out.printf("Booked %s for %s: fare ₹%.2f%n", v.type, riderId, fare);
        return ride;
    }

    private double calculateFare(Vehicle v, double distanceKm) {
        double base = 50; // base fare
        double fare = base + (distanceKm * v.baseRatePerKm());
        // example operator usage for surge: short surge for peak hours (simulate)
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 18 && hour <= 20) fare *= 1.2; // surge 20%
        return fare;
    }

    @Override
    public void endRide(Ride r) {
        System.out.printf("Ride %s ended. Fare: ₹%.2f. Driver: %s%n", r.rideId, r.getFare(), r.driver.getName());
    }
}

public class CabbyGoDemo {
    public static void main(String[] args) {
        RideService service = new RideService();
        service.registerDriver("D1", new Driver("Suresh", "LIC123", 4.8));

        Ride r = service.bookRide("Rider42", "suv", 12.5);
        if (r != null) service.endRide(r);
    }
}
