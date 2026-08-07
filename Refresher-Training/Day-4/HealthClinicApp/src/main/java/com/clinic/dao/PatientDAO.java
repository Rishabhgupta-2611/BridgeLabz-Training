package com.clinic.dao;

import java.util.List;

import com.clinic.dto.Patient;

public interface PatientDAO {

    int addPatient(Patient patient);

    Patient getPatientById(int patientId);

    List<Patient> getAllPatients();

    boolean updatePatient(Patient patient);

    boolean deletePatient(int patientId);
}