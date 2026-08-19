package com.gla.service;

import com.gla.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Integer id);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Integer id, StudentDTO studentDTO);

    void deleteStudent(Integer id);

    List<StudentDTO> getStudentsByDepartment(String department);

    List<StudentDTO> getStudentsByCity(String city);

    List<StudentDTO> getStudentsByCourse(String course);
}