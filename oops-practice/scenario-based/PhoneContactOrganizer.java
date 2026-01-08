import java.util.*;

class InvalidPhoneNumberException extends Exception {
	InvalidPhoneNumberException(String message) {
		super(message);
	}
}

class Contact {
	private String name;
	private String phoneNumber;

	Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	String getName() {
		return name;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}
}

public class PhoneContactOrganizer {

	private static List<Contact> contacts = new ArrayList<>();

	static void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {

		if (!phoneNumber.matches("\\d{10}")) {
			throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
		}

		for (Contact c : contacts) {
			if (c.getPhoneNumber().equals(phoneNumber)) {
				System.out.println("Duplicate contact not allowed");
				return;
			}
		}

		contacts.add(new Contact(name, phoneNumber));
		System.out.println("Contact added successfully");
	}

	static void deleteContact(String phoneNumber) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
				contacts.remove(i);
				System.out.println("Contact deleted successfully");
				return;
			}
		}
		System.out.println("Contact not found");
	}

	static void searchContact(String keyword) {
		boolean found = false;

		for (Contact c : contacts) {
			if (c.getName().toLowerCase().contains(keyword.toLowerCase()) || c.getPhoneNumber().contains(keyword)) {
				System.out.println(c.getName() + " - " + c.getPhoneNumber());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No matching contact found");
		}
	}

	public static void main(String[] args) {

		try {
			addContact("Ravi", "9876543210");
			addContact("Amit", "9123456789");
			addContact("Duplicate", "9876543210");
			addContact("Invalid", "12345");
		} catch (InvalidPhoneNumberException e) {
			System.out.println(e.getMessage());
		}

		searchContact("Ravi");
		deleteContact("9123456789");
		searchContact("9");
	}
}
