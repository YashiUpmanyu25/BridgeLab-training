import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    public Vehicle(String num, String type, double rate) {
        this.vehicleNumber = num; this.type = type; this.rentalRate = rate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String v) { vehicleNumber = v; }

    public String getType() { return type; }
    public void setType(String t) { type = t; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double r) { rentalRate = r; }

    public abstract double calculateRentalCost(int days);

    public void printDetails() {
        System.out.printf("%s (%s) - Rate/day: %.2f%n", vehicleNumber, type, rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNum;

    public Car(String num, double rate, String policy) {
        super(num,"Car",rate);
        this.policyNum = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500.0; // flat example
    }

    @Override
    public String getInsuranceDetails() {
        return "Car policy: " + (policyNum == null ? "N/A" : policyNum);
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNum;
    public Bike(String num, double rate, String policy) {
        super(num,"Bike",rate);
        this.policyNum = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 150.0; }
    @Override
    public String getInsuranceDetails() {
        return "Bike policy: " + (policyNum == null ? "N/A" : policyNum);
    }
}

class Truck extends Vehicle {
    public Truck(String num, double rate) {
        super(num,"Truck",rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        // extra fee for trucks
        return getRentalRate() * days + 200.0;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("KA01AB1234", 3000, "CAR-INS-001"));
        fleet.add(new Bike("KA01CD5678", 700, "BIKE-INS-010"));
        fleet.add(new Truck("KA01TR9999", 5000));

        int days = 3;
        for (Vehicle v : fleet) {
            v.printDetails();
            double rent = v.calculateRentalCost(days);
            System.out.printf("  Rental for %d days: %.2f%n", days, rent);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.printf("  Insurance: %.2f (%s)%n", ins.calculateInsurance(), ins.getInsuranceDetails());
            } else {
                System.out.println("  Not insurable via interface");
            }
            System.out.println("---");
        }
    }
}
