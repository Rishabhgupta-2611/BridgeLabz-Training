package com.clinic.dao;

import java.util.List;
import com.clinic.dto.Doctor;

public interface DoctorDAO {

    int addDoctor(Doctor doctor);

    Doctor getDoctorById(int doctorId);

    List<Doctor> getAllDoctors();

    boolean updateDoctor(Doctor doctor);

    boolean deleteDoctor(int doctorId);
}