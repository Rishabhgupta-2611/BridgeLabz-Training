package com.example.contacts.service;

import com.example.contacts.dto.ContactRequestDTO;
import com.example.contacts.dto.ContactResponseDTO;
import com.example.contacts.entity.Contact;
import com.example.contacts.exception.ContactNotFoundException;
import com.example.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponseDTO createContact(ContactRequestDTO request) {

        Contact contact = new Contact();

        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());

        Contact savedContact = contactRepository.save(contact);

        return convertToResponseDTO(savedContact);
    }

    @Override
    public List<ContactResponseDTO> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    @Override
    public ContactResponseDTO getContactById(Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with id: " + id));

        return convertToResponseDTO(contact);
    }

    @Override
    public ContactResponseDTO updateContact(
            Long id,
            ContactRequestDTO request) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with id: " + id));

        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());

        Contact updatedContact = contactRepository.save(contact);

        return convertToResponseDTO(updatedContact);
    }

    @Override
    public void deleteContact(Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with id: " + id));

        contactRepository.delete(contact);
    }

    private ContactResponseDTO convertToResponseDTO(Contact contact) {

        return new ContactResponseDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getEmail()
        );
    }
}