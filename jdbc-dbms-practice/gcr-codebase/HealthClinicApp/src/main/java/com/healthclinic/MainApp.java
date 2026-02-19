package com.healthclinic;
import com.healthclinic.dao.*;
import com.healthclinic.model.*;
import com.healthclinic.utils.DBConnection;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;

public class MainApp {

    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connected to Database Successfully!");

            // Create DAO objects
            PatientDAO patientDAO = new PatientDAO();
            DoctorDAO doctorDAO = new DoctorDAO();
            AppointmentDAO appointmentDAO = new AppointmentDAO();
            VisitDAO visitDAO = new VisitDAO();
            BillDAO billDAO = new BillDAO();

            // -------- TEST FLOW --------

            //Register Patient
            Patient patient = new Patient();
            patient.setName("Aryan Chaturvedi");
            patient.setDob(Date.valueOf("2002-05-15"));
            patient.setPhone("9999999999");
            patient.setEmail("aryan@email.com");
            patient.setAddress("Jalaun, UP");
            patient.setBloodGroup("B+");

            patientDAO.addPatient(patient);

            //Add Doctor
            Doctor doctor = new Doctor();
            doctor.setName("Dr. Sharma");
            doctor.setSpecialty("Cardiology");
            doctor.setPhone("8888888888");
            doctor.setConsultationFee(500.00);

            doctorDAO.addDoctor(doctor);

            //Book Appointment
            Appointment appointment = new Appointment();
            appointment.setPatientId(1);   // assuming first patient
            appointment.setDoctorId(1);    // assuming first doctor
            appointment.setAppointmentDate(
                    Timestamp.valueOf("2026-02-12 10:00:00")
            );
            appointmentDAO.bookAppointment(appointment);

            //Record Visit
            Visit visit = new Visit();
            visit.setAppointmentId(1);
            visit.setDiagnosis("Mild chest pain");
            visit.setBillAmount(500.00);

            visitDAO.recordVisit(visit);

            //Generate Bill
            billDAO.generateBill(1, 500.00);

            System.out.println("Test Flow Executed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
