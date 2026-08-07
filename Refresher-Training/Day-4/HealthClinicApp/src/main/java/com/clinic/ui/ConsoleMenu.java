package com.clinic.ui;

import java.sql.Date;
import java.util.Scanner;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;

import com.clinic.dao.PatientDAO;
import com.clinic.dao.PatientDAOImpl;
import com.clinic.dto.Patient;
import com.clinic.dao.DoctorDAO;
import com.clinic.dao.DoctorDAOImpl;
import com.clinic.dto.Doctor;
import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.AppointmentDAOImpl;
import com.clinic.dto.Appointment;
import com.clinic.service.AppointmentService;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.BillingDAOImpl;
import com.clinic.dto.Billing;

public class ConsoleMenu {

    private Scanner sc = new Scanner(System.in);

    private PatientDAO patientDAO = new PatientDAOImpl();
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    
    private AppointmentService appointmentService = new AppointmentService();
    private BillingDAO billingDAO = new BillingDAOImpl();
    
    private void addPatient() {

        try {

            System.out.println("\n===== Add Patient =====");

            System.out.print("First Name : ");
            String firstName = sc.next();

            System.out.print("Last Name : ");
            String lastName = sc.next();

            System.out.print("Date of Birth (yyyy-mm-dd) : ");
            Date dob = Date.valueOf(sc.next());

            System.out.print("Gender (Male/Female/Other) : ");
            String gender = sc.next();

            System.out.print("Phone Number : ");
            String phone = sc.next();

            System.out.print("Email : ");
            String email = sc.next();

            Patient patient = new Patient(
                    firstName,
                    lastName,
                    dob,
                    gender,
                    phone,
                    email,
                    true);

            int id = patientDAO.addPatient(patient);

            if (id > 0) {

                System.out.println("\nPatient Added Successfully.");
                System.out.println("Generated Patient ID : " + id);

            } else {

                System.out.println("\nFailed to Add Patient.");

            }

        } catch (Exception e) {

            System.out.println("Invalid Input!");

        }

    }
    
    private void viewPatients() {

        System.out.println("\n===== All Patients =====");

        try {

            var patients = patientDAO.getAllPatients();

            if (patients.isEmpty()) {

                System.out.println("No patients found.");

                return;
            }

            for (Patient patient : patients) {

                System.out.println("-----------------------------");
                System.out.println("Patient ID   : " + patient.getPatientId());
                System.out.println("Name         : "
                        + patient.getFirstName() + " "
                        + patient.getLastName());
                System.out.println("Date of Birth: " + patient.getDateOfBirth());
                System.out.println("Gender       : " + patient.getGender());
                System.out.println("Phone        : " + patient.getPhoneNumber());
                System.out.println("Email        : " + patient.getEmail());
                System.out.println("Active       : " + patient.isActive());
            }

            System.out.println("-----------------------------");

        } catch (Exception e) {

            System.out.println("Unable to fetch patients.");
            e.printStackTrace();
        }
    }
    
    private void addDoctor() {

        try {

            System.out.println("\n===== Add Doctor =====");

            System.out.print("First Name : ");
            String firstName = sc.next();

            System.out.print("Last Name : ");
            String lastName = sc.next();

            System.out.print("Phone Number : ");
            String phone = sc.next();

            System.out.print("Email : ");
            String email = sc.next();

            Doctor doctor = new Doctor(
                    firstName,
                    lastName,
                    phone,
                    email,
                    true
            );

            int id = doctorDAO.addDoctor(doctor);

            if (id > 0) {

                System.out.println("\nDoctor Added Successfully.");
                System.out.println("Generated Doctor ID : " + id);

            } else {

                System.out.println("\nFailed to Add Doctor.");
            }

        } catch (Exception e) {

            System.out.println("Unable to add doctor.");
            e.printStackTrace();
        }
    }
    
    private void viewDoctors() {

        System.out.println("\n===== All Doctors =====");

        try {

            var doctors = doctorDAO.getAllDoctors();

            if (doctors.isEmpty()) {

                System.out.println("No doctors found.");
                return;
            }

            for (Doctor doctor : doctors) {

                System.out.println("-----------------------------");
                System.out.println("Doctor ID    : " + doctor.getDoctorId());
                System.out.println("Name         : "
                        + doctor.getFirstName() + " "
                        + doctor.getLastName());
                System.out.println("Phone        : " + doctor.getPhoneNumber());
                System.out.println("Email        : " + doctor.getEmail());
                System.out.println("Active       : " + doctor.isActive());
            }

            System.out.println("-----------------------------");

        } catch (Exception e) {

            System.out.println("Unable to fetch doctors.");
            e.printStackTrace();
        }
    }
    
    private void bookAppointment() {

        try {

            System.out.println("\n===== Book Appointment =====");

            System.out.print("Patient ID : ");
            int patientId = sc.nextInt();

            System.out.print("Doctor ID : ");
            int doctorId = sc.nextInt();

            System.out.print("Appointment Date and Time (yyyy-MM-dd HH:mm:ss) : ");
            sc.nextLine();
            String dateTime = sc.nextLine();

            Timestamp appointmentDate = Timestamp.valueOf(dateTime);

            Appointment appointment = new Appointment();

            appointment.setPatientId(patientId);
            appointment.setDoctorId(doctorId);
            appointment.setAppointmentDate(appointmentDate);
            appointment.setStatus("Scheduled");

            int id = appointmentDAO.bookAppointment(appointment);

            if (id > 0) {

                System.out.println("\nAppointment Booked Successfully.");
                System.out.println("Appointment ID : " + id);

            } else {

                System.out.println("\nFailed to Book Appointment.");

            }

        } catch (Exception e) {

            System.out.println("\nUnable to book appointment.");
            System.out.println("Please check the entered details.");
            e.printStackTrace();
        }
    }
    
    private void viewAppointments() {

        System.out.println("\n===== All Appointments =====");

        try {

            var appointments = appointmentDAO.getAllAppointments();

            if (appointments.isEmpty()) {

                System.out.println("No appointments found.");
                return;
            }

            for (Appointment appointment : appointments) {

                System.out.println("-----------------------------");
                System.out.println("Appointment ID : "
                        + appointment.getAppointmentId());

                System.out.println("Patient ID     : "
                        + appointment.getPatientId());

                System.out.println("Doctor ID      : "
                        + appointment.getDoctorId());

                System.out.println("Date & Time    : "
                        + appointment.getAppointmentDate());

                System.out.println("Status         : "
                        + appointment.getStatus());
            }

            System.out.println("-----------------------------");

        } catch (Exception e) {

            System.out.println("Unable to fetch appointments.");
            e.printStackTrace();
        }
    }
    
    private void completeAppointment() {

        try {

            System.out.println("\n===== Complete Appointment =====");

            System.out.print("Appointment ID : ");
            int appointmentId = sc.nextInt();

            sc.nextLine();

            System.out.print("Diagnosis : ");
            String diagnosis = sc.nextLine();

            System.out.print("Prescription : ");
            String prescription = sc.nextLine();

            System.out.print("Visit Notes : ");
            String notes = sc.nextLine();

            System.out.print("Bill Amount : ");
            BigDecimal amount = sc.nextBigDecimal();

            boolean result = appointmentService.completeAppointment(
                    appointmentId,
                    diagnosis,
                    prescription,
                    notes,
                    amount
            );

            if (result) {

                System.out.println("\nAppointment Completed Successfully.");
                System.out.println("Appointment Status : Completed");
                System.out.println("Bill Generated Successfully.");
                System.out.println("Visit History Added Successfully.");

            } else {

                System.out.println("\nFailed to complete appointment.");

            }

        } catch (Exception e) {

            System.out.println("\nInvalid input or operation failed.");
            e.printStackTrace();
        }
    }
    
    private void viewBills() {

        System.out.println("\n===== All Bills =====");

        try {

            var bills = billingDAO.getAllBills();

            if (bills.isEmpty()) {

                System.out.println("No bills found.");
                return;
            }

            for (Billing bill : bills) {

                System.out.println("-----------------------------");

                System.out.println("Bill ID         : "
                        + bill.getBillId());

                System.out.println("Appointment ID  : "
                        + bill.getAppointmentId());

                System.out.println("Amount          : "
                        + bill.getAmount());

                System.out.println("Payment Status  : "
                        + bill.getPaymentStatus());

                System.out.println("Billing Date    : "
                        + bill.getBillingDate());
            }

            System.out.println("-----------------------------");

        } catch (Exception e) {

            System.out.println("Unable to fetch bills.");
            e.printStackTrace();
        }
    }

    public void displayMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== HEALTH CLINIC MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Complete Appointment");
            System.out.println("8. View Bills");
            System.out.println("9. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                addPatient();
                break;

            case 2:
                viewPatients();
                break;

            case 3:
                addDoctor();
                break;

            case 4:
                viewDoctors();
                break;

            case 5:
                bookAppointment();
                break;

            case 6:
                viewAppointments();
                break;

            case 7:
                completeAppointment();
                break;

            case 8:
                viewBills();
                break;

            case 9:
                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice");

            }

        }

    }

}