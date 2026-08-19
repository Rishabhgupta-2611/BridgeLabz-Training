package com.gla.repository;

import com.gla.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository
        extends JpaRepository<Faculty, Integer> {

    List<Faculty> findByDepartment(String department);

    List<Faculty> findByDesignation(String designation);

    @Query("""
			SELECT f.department, MAX(f.salary)
           FROM Faculty f
           GROUP BY f.department
           """)
    List<Object[]> findMaximumSalaryByDepartment();

    @Query("""
           SELECT f
           FROM Faculty f
           WHERE f.salary > (
               SELECT AVG(f2.salary)
               FROM Faculty f2
               WHERE f2.department = f.department
           )
           """)
    List<Faculty> findFacultyAboveDepartmentAverageSalary();
}