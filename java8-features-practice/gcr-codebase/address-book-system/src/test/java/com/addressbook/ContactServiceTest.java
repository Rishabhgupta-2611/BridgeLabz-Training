package com.addressbook;
import com.addressbook.dao.ContactDAO;
import com.addressbook.model.ContactPerson;
import com.addressbook.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	private ContactService contactService;

    @BeforeEach
    void setUp() {
        ContactDAO contactDAO = new ContactDAO();
        contactService = new ContactService(contactDAO);
    }

    @Test
    void testAddContactSuccess() {
        ContactPerson person = new ContactPerson(
                "Rishabh", "2/1011 A,",
                "MACHHARHATTA WARD Ramnagar", "Varanasi",
                "UP", "221008",
                "9999999999", "rishabh@email.com"
        );

        String result = contactService.addContact(person);
        assertEquals("Contact added successfully.", result);
        assertEquals(1, contactService.getAllContacts().size());
    }

    @Test
    void testAddDuplicateContact() {
        ContactPerson person1 = new ContactPerson(
                "Aryan", "Chaturvedi",
                "Address1", "City1",
                "State1", "111111",
                "1234567890", "email1@test.com"
        );

        ContactPerson person2 = new ContactPerson(
                "Aryan", "Chaturvedi",
                "Address2", "City2",
                "State2", "222222",
                "9999999999", "email2@test.com"
        );

        contactService.addContact(person1);
        String result = contactService.addContact(person2);

        assertEquals("Contact already exists with this name.", result);
        assertEquals(1, contactService.getAllContacts().size());
    }

    @Test
    void testDeleteContactSuccess() {
        ContactPerson person = new ContactPerson(
                "Rahul", "Sharma",
                "Address", "Delhi",
                "Delhi", "110001",
                "8888888888", "rahul@test.com"
        );

        contactService.addContact(person);

        String result = contactService.deleteContact("Rahul", "Sharma");
        assertEquals("Contact deleted.", result);
        assertTrue(contactService.getAllContacts().isEmpty());
    }

    @Test
    void testDeleteContactNotFound() {
        String result = contactService.deleteContact("Not", "Exist");
        assertEquals("Contact not found.", result);
    }

    @Test
    void testUpdateContactSuccess() {
        ContactPerson oldPerson = new ContactPerson(
                "Aman", "Verma",
                "Old Address", "Lucknow",
                "UP", "226001",
                "7777777777", "aman@test.com"
        );

        contactService.addContact(oldPerson);
        ContactPerson updated = new ContactPerson(
                "Aman", "Verma",
                "New Address", "Noida",
                "UP", "201301",
                "6666666666", "new@test.com"
        );

        String result = contactService.updateContact("Aman", "Verma", updated);
        assertEquals("Contact updated.", result);

        ContactPerson fetched = contactService.getContactByName("Aman", "Verma");
        assertEquals("New Address", fetched.getAddress());
        assertEquals("Noida", fetched.getCity());
    }

    @Test
    void testUpdateContactNotFound() {
        ContactPerson updated = new ContactPerson(
                "X", "Y",
                "Address", "City",
                "State", "000000",
                "0000000000", "x@test.com"
        );

        String result = contactService.updateContact("Unknown", "Person", updated);

        assertEquals("Contact not found.", result);
    }
}