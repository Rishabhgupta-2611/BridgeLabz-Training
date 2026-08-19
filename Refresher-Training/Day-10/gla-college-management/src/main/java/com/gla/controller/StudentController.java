package com.gla.controller;

import com.gla.dto.StudentDTO;
import com.gla.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO dto) {

		return new ResponseEntity<>(studentService.createStudent(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<StudentDTO>> getAllStudents() {

		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) {

		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO dto) {

		return ResponseEntity.ok(studentService.updateStudent(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {

		studentService.deleteStudent(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<List<StudentDTO>> getStudentsByDepartment(@PathVariable String department) {

		return ResponseEntity.ok(studentService.getStudentsByDepartment(department));
	}

	@GetMapping("/city/{city}")
	public ResponseEntity<List<StudentDTO>> getStudentsByCity(@PathVariable String city) {

		return ResponseEntity.ok(studentService.getStudentsByCity(city));
	}

	@GetMapping("/course/{course}")
	public ResponseEntity<List<StudentDTO>> getStudentsByCourse(@PathVariable String course) {

		return ResponseEntity.ok(studentService.getStudentsByCourse(course));
	}
}