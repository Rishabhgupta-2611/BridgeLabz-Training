package com.employee.payroll.repository;

import com.employee.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartmentIgnoreCase(String department);

	List<Employee> findByDesignationIgnoreCase(String designation);
}