package hospitalManagementSystem;
import java.util.*;

class Hospital implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.name);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("\nDoctor added: Dr. " + doctor.name);
    }

    public void bookAppointment(Patient patient, Doctor doctor)
            throws AppointmentNotAvailableException {

        for (Appointment a : appointments) {
            if (a != null && a.toString().contains(doctor.getName())) {
                throw new AppointmentNotAvailableException("Doctor not available");
            }
        }

        Appointment appointment = new Appointment(patient, doctor);
        appointments.add(appointment);

        System.out.println("\nAppointment booked with Dr. " + doctor.getName());
        System.out.println("Consultation Fee: ₹" + doctor.calculateConsultationFee());
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("\nAppointment cancelled");
    }
}
