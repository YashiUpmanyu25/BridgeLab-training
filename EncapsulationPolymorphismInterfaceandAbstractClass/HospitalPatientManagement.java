import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.patientId = id; this.name = name; this.age = age;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String id) { patientId = id; }

    public String getName() { return name; }
    public void setName(String n) { name = n; }

    public int getAge() { return age; }
    public void setAge(int a) { age = a; }

    public void getPatientDetails() {
        System.out.printf("%s: %s, Age %d%n", patientId, name, age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String rec);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int days) {
        super(id, name, age); this.daysAdmitted = days;
    }

    @Override
    public double calculateBill() {
        double daily = 2000.0;
        return daysAdmitted * daily + 5000; // base + daily
    }

    @Override
    public void addRecord(String rec) { records.add(rec); }

    @Override
    public List<String> viewRecords() { return records; }
}

class OutPatient extends Patient implements MedicalRecord {
    private int consultations;
    private List<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age, int consultations) {
        super(id, name, age); this.consultations = consultations;
    }

    @Override
    public double calculateBill() {
        double perConsult = 500.0;
        return consultations * perConsult;
    }

    @Override
    public void addRecord(String rec) { records.add(rec); }

    @Override
    public List<String> viewRecords() { return records; }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient("IP001","Suma",45,5);
        ip.addRecord("Surgery done");
        ip.addRecord("Post-op stable");

        OutPatient op = new OutPatient("OP001","Ramesh",30,2);
        op.addRecord("Prescribed medication");

        patients.add(ip); patients.add(op);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.printf("  Bill: %.2f%n", p.calculateBill());
            if (p instanceof MedicalRecord) {
                System.out.println("  Records: " + ((MedicalRecord)p).viewRecords());
            }
            System.out.println("---");
        }
    }
}
