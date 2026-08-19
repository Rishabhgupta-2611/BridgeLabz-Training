package com.gla.service;

import com.gla.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    FacultyDTO createFaculty(FacultyDTO facultyDTO);

    FacultyDTO getFacultyById(Integer id);

    List<FacultyDTO> getAllFaculty();

    FacultyDTO updateFaculty(Integer id, FacultyDTO facultyDTO);

    void deleteFaculty(Integer id);

    List<FacultyDTO> getFacultyByDepartment(String department);

    List<Object[]> getMaximumSalaryByDepartment();

    List<FacultyDTO> getFacultyAboveDepartmentAverageSalary();
}