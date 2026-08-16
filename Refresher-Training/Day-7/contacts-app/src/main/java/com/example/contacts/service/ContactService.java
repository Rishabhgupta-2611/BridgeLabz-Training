package com.example.contacts.service;

import com.example.contacts.dto.ContactRequestDTO;
import com.example.contacts.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    ContactResponseDTO createContact(ContactRequestDTO request);

    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO updateContact(
            Long id,
            ContactRequestDTO request);

    void deleteContact(Long id);
}