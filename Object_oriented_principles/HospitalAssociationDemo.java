import java.util.*;

class Patient {
    String name;
    Patient(String name) { this.name = name; }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) { this.name = name; }

    void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " is consulting patient " + p.name);
    }
}

class Hospital {
    String name;
    Hospital(String name) { this.name = name; }
}

public class HospitalAssociationDemo {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Dr. Singh");
        Doctor d2 = new Doctor("Dr. Patel");

        Patient p1 = new Patient("Pragati");
        Patient p2 = new Patient("Unnati");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}
