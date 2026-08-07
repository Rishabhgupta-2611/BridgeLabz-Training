package com.clinic.dao;

import java.util.List;

public interface DoctorSpecializationDAO {

    boolean assignSpecialization(int doctorId, int specializationId);

    boolean removeSpecialization(int doctorId, int specializationId);

    List<Integer> getSpecializationsByDoctor(int doctorId);

}