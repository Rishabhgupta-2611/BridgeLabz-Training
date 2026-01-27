package com.addressbook.dao;

import com.addressbook.model.ContactPerson;
import java.util.*;

import java.util.*;


public class ContactDAO {
	List<ContactPerson> contacts = new ArrayList<>();
	
	public void addContact(ContactPerson contact) {
		contacts.add(contact);
	}
	
	public List<ContactPerson> getAllContacts() {
		return new ArrayList<>(contacts);
	}
	
	public ContactPerson findByName(String firstName, String lastName) {
        for (ContactPerson c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)
                    && c.getLastName().equalsIgnoreCase(lastName)) {
                return c;
            }
        }
        return null;
    }
	
	public boolean deleteByName(String firstName, String lastName) {
        ContactPerson toDelete = findByName(firstName, lastName);
        if (toDelete != null) {
            contacts.remove(toDelete);
            return true;
        }
        return false;
    }
	
		
}
