package com.gla.controller;

import com.gla.dto.FacultyDTO;
import com.gla.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}