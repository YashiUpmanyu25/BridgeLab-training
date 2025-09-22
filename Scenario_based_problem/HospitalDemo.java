// File: HospitalDemo.java
import java.util.*;

interface Payable {
    double calculatePayment(); // abstraction for billing
}

class Patient {
    private final String id;
    private String name;
    private int age;
    private String medicalHistory; // sensitive
    protected boolean emergency;

    public Patient(String id, String name, int age) { // normal
        this(id, name, age, "", false);
    }

    // overloaded constructor for emergency admission
    public Patient(String id, String name, int age, String medicalHistory, boolean emergency) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.emergency = emergency;
    }

    public String getSummary() { // public view (encapsulation)
        return String.format("Patient[%s] %s, age %d, emergency=%b", id, name, age, emergency);
    }

    protected String getMedicalHistory() { // restricted access for subclasses
        return medicalHistory;
    }

    public void setMedicalHistory(String hx) {
        this.medicalHistory = hx;
    }

    public void displayInfo() { // polymorphic target
        System.out.println(getSummary());
    }
}

class InPatient extends Patient {
    private String ward;
    private int bedNumber;

    public InPatient(String id, String name, int age, String ward, int bedNumber) {
        super(id, name, age);
        this.ward = ward;
        this.bedNumber = bedNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.getSummary() + " (InPatient, ward " + ward + ", bed " + bedNumber + ")");
    }
}

class OutPatient extends Patient {
    private Date appointment;

    public OutPatient(String id, String name, int age, Date appointment) {
        super(id, name, age, "", false);
        this.appointment = appointment;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.getSummary() + " (OutPatient, appointment " + appointment + ")");
    }
}

class Doctor {
    private String name;
    private String specialization;
    protected String employeeId;

    public Doctor(String employeeId, String name, String specialization) {
        this.employeeId = employeeId;
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Dr. " + name + " (" + specialization + ")");
    }
}

class Bill implements Payable {
    private final String billId;
    private final Patient patient;
    private double baseCharges;
    private double taxPct;
    private double discount;

    public Bill(String billId, Patient patient, double baseCharges) {
        this.billId = billId;
        this.patient = patient;
        this.baseCharges = baseCharges;
        this.taxPct = 5.0;
        this.discount = patient.emergency ? 0.0 : 2.0; // operator usage
    }

    @Override
    public double calculatePayment() {
        double taxed = baseCharges + (baseCharges * taxPct / 100.0);
        double afterDiscount = taxed - (taxed * discount / 100.0);
        return Math.max(afterDiscount, 0.0);
    }

    public void printBill() {
        System.out.printf("Bill %s for %s: total ₹%.2f%n", billId, patient.getSummary(), calculatePayment());
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P100", "Anita", 45, "A", 12);
        Patient p2 = new OutPatient("P101", "Rohit", 30, new Date());

        Doctor d = new Doctor("D55", "Meera Sharma", "Cardiology");

        p1.displayInfo();
        p2.displayInfo();
        d.displayInfo();

        Bill b1 = new Bill("B1000", p1, 7500.0);
        Bill b2 = new Bill("B1001", p2, 1200.0);

        b1.printBill();
        b2.printBill();
    }
}
