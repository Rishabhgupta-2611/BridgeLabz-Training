package hospitalManagementSystem;
import java.util.*;

class Patient extends Person {

    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String id, String name) {
        super(id, name);
    }

    public void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewMedicalHistory() {
        System.out.println("\nMedical History of " + name);
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}