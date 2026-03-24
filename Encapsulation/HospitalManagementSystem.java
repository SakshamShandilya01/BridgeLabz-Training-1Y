
// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method
    abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private String record = "";

    public InPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    double calculateBill() {
        return 5000; // fixed hospitalization charge
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private String record = "";

    public OutPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    double calculateBill() {
        return 1000; // consultation charge
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

// Main class
public class HospitalManagementSystem {

    public static void main(String[] args) {

        Patient[] patients = {
                new InPatient(1, "Patient1", 30),
                new OutPatient(2, "Patient2", 25)
        };

        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());

            MedicalRecord m = (MedicalRecord) p;
            m.addRecord("General Checkup");
            m.viewRecords();

            System.out.println("----------------------");
        }
    }
}