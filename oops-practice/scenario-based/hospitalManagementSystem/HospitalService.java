package hospitalManagementSystem;

public interface HospitalService {
	void addPatient(Patient patient);
    void addDoctor(Doctor doctor);
    void bookAppointment(Patient patient, Doctor doctor) throws AppointmentNotAvailableException;
    void cancelAppointment(Appointment appointment);
}
