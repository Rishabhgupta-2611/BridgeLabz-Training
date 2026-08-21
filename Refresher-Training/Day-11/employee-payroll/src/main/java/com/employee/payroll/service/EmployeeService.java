package com.employee.payroll.service;

import com.employee.payroll.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

	EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeById(Long id);

	EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

	void deleteEmployee(Long id);

	List<EmployeeDTO> getEmployeesByDepartment(String department);

	List<EmployeeDTO> getEmployeesByDesignation(String designation);
}