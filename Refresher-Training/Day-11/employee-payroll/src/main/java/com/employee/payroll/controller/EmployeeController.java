package com.employee.payroll.controller;

import com.employee.payroll.dto.EmployeeDTO;
import com.employee.payroll.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

		EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeeDTO employeeDTO) {

		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

		return ResponseEntity.ok("Employee deleted successfully");
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(@PathVariable String department) {

		return ResponseEntity.ok(employeeService.getEmployeesByDepartment(department));
	}

	@GetMapping("/designation/{designation}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByDesignation(@PathVariable String designation) {

		return ResponseEntity.ok(employeeService.getEmployeesByDesignation(designation));
	}
}