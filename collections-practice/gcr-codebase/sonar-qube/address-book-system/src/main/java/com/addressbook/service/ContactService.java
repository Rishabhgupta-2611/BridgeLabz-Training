package com.addressbook.service;
import com.addressbook.dao.ContactDAO;
import com.addressbook.model.ContactPerson;
import java.util.*;

public class ContactService {

	private final ContactDAO contactDAO;

	public ContactService(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	// (UC : 1)
	public String addContact(ContactPerson contact) {
		if (contact.getFirstName() == null || contact.getLastName() == null) {
			return "First name and last name are required.";
		}

		ContactPerson existing = contactDAO.findByName(contact.getFirstName(), contact.getLastName());

		if (existing != null) {
			return "Contact already exists with this name.";
		}

		contactDAO.addContact(contact);
		return "Contact added successfully.";
	}

	public List<ContactPerson> getAllContacts() {
		return contactDAO.getAllContacts();
	}

	public ContactPerson getContactByName(String firstName, String lastName) {
		return contactDAO.findByName(firstName, lastName);
	}

	public String deleteContact(String firstName, String lastName) {
		boolean removed = contactDAO.deleteByName(firstName, lastName);
		return removed ? "Contact deleted." : "Contact not found.";
	}

	public String updateContact(String firstName, String lastName, ContactPerson updated) {
		ContactPerson existing = contactDAO.findByName(firstName, lastName);
		if (existing == null) {
			return "Contact not found.";
		}

		// updating all the fileds
		existing.setAddress(updated.getAddress());
		existing.setCity(updated.getCity());
		existing.setState(updated.getState());
		existing.setZip(updated.getZip());
		existing.setPhone(updated.getPhone());
		existing.setEmail(updated.getEmail());
		existing.setFirstName(updated.getFirstName());
		existing.setLastName(updated.getLastName());

		return "Contact updated.";
	}
}
