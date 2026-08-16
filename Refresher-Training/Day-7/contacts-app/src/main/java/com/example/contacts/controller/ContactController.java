package com.example.contacts.controller;

import com.example.contacts.dto.ContactRequestDTO;
import com.example.contacts.dto.ContactResponseDTO;
import com.example.contacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@PostMapping
	public ResponseEntity<ContactResponseDTO> createContact(@Valid @RequestBody ContactRequestDTO request) {

		ContactResponseDTO response = contactService.createContact(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<ContactResponseDTO>> getAllContacts() {

		List<ContactResponseDTO> contacts = contactService.getAllContacts();

		return ResponseEntity.ok(contacts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id) {

		ContactResponseDTO response = contactService.getContactById(id);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable Long id,
			@Valid @RequestBody ContactRequestDTO request) {

		ContactResponseDTO response = contactService.updateContact(id, request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long id) {

		contactService.deleteContact(id);

		return ResponseEntity.noContent().build();
	}
}