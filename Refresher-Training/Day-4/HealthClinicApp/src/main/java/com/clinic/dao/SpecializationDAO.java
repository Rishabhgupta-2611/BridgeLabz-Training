package com.clinic.dao;

import java.util.List;
import com.clinic.dto.Specialization;

public interface SpecializationDAO {

    int addSpecialization(Specialization specialization);

    Specialization getSpecializationById(int specializationId);

    List<Specialization> getAllSpecializations();

    boolean updateSpecialization(Specialization specialization);

    boolean deleteSpecialization(int specializationId);

}