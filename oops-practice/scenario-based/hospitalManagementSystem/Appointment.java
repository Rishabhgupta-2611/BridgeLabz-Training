package hospitalManagementSystem;

class Appointment {
    private Patient patient;
    private Doctor doctor;

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public void showAppointment() {
        System.out.println("Appointment: " + patient.name + " with Dr. " + doctor.getName());
    }
}
