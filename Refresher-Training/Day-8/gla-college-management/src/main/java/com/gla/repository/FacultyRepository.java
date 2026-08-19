package com.gla.repository;

import com.gla.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository
        extends JpaRepository<Faculty, Integer> {

    List<Faculty> findByDepartment(String department);

    List<Faculty> findByDesignation(String designation);

}