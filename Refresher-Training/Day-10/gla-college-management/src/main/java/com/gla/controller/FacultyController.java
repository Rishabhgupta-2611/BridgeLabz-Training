package com.gla.controller;

import com.gla.dto.FacultyDTO;
import com.gla.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	private final FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@PostMapping
	public ResponseEntity<FacultyDTO> createFaculty(@Valid @RequestBody FacultyDTO dto) {

		return new ResponseEntity<>(facultyService.createFaculty(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<FacultyDTO>> getAllFaculty() {

		return ResponseEntity.ok(facultyService.getAllFaculty());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FacultyDTO> getFacultyById(@PathVariable Integer id) {

		return ResponseEntity.ok(facultyService.getFacultyById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<FacultyDTO> updateFaculty(@PathVariable Integer id, @Valid @RequestBody FacultyDTO dto) {

		return ResponseEntity.ok(facultyService.updateFaculty(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFaculty(@PathVariable Integer id) {

		facultyService.deleteFaculty(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<List<FacultyDTO>> getFacultyByDepartment(@PathVariable String department) {

		return ResponseEntity.ok(facultyService.getFacultyByDepartment(department));
	}

	@GetMapping("/salary/max-by-department")
	public ResponseEntity<List<Object[]>> getMaximumSalaryByDepartment() {

		return ResponseEntity.ok(facultyService.getMaximumSalaryByDepartment());
	}

	@GetMapping("/salary/above-department-average")
	public ResponseEntity<List<FacultyDTO>> getFacultyAboveDepartmentAverageSalary() {

		return ResponseEntity.ok(facultyService.getFacultyAboveDepartmentAverageSalary());
	}
}