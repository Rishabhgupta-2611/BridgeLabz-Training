package hospitalManagementSystem;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Patient p1 = new Patient("P101", "Aryan");
        Doctor d1 = new Doctor("D201", "Sharma", "Cardiology", 800);

        hospital.addPatient(p1);
        hospital.addDoctor(d1);

        p1.addMedicalRecord("Blood Test: Normal");
        p1.addMedicalRecord("ECG: Normal");

        try {
            hospital.bookAppointment(p1, d1);
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.viewMedicalHistory();
    }
}
