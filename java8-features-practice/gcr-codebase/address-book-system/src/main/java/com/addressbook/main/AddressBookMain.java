package com.addressbook.main;
import com.addressbook.service.ContactService;
import com.addressbook.dao.ContactDAO;
import com.addressbook.model.ContactPerson;
import java.util.*;


public class AddressBookMain {

	private static ContactPerson readContact(Scanner input) {
		System.out.print("First Name: ");
		String firstName = input.nextLine();

		System.out.print("Last Name: ");
		String lastName = input.nextLine();

		System.out.print("Address: ");
		String address = input.nextLine();

		System.out.print("City: ");
		String city = input.nextLine();

		System.out.print("State: ");
		String state = input.nextLine();

		System.out.print("Zip: ");
		String zip = input.nextLine();

		System.out.print("Phone: ");
		String phone = input.nextLine();

		System.out.print("Email: ");
		String email = input.nextLine();

		return new ContactPerson(firstName, lastName, address, city, state, zip, phone, email);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");

		Scanner input = new Scanner(System.in);
		ContactDAO contactDAO = new ContactDAO();
		ContactService contactService = new ContactService(contactDAO);

		boolean running = true;

		while (running) {
			System.out.println("\n1. Add Contact");
			System.out.println("2. View All Contacts");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int choice = Integer.parseInt(input.nextLine());

			switch (choice) {
			case 1:
				ContactPerson newContact = readContact(input);
				String addMsg = contactService.addContact(newContact);
				System.out.println(addMsg);
				break;

			case 2:
				List<ContactPerson> contacts = contactService.getAllContacts();
				if (contacts.isEmpty()) {
					System.out.println("\nNo contacts found.\n");
				} else {
					System.out.println("\nDisplaying All Contacts:");
					for (ContactPerson c : contacts) {
						//System.out.println(c);
						c.displayDetails();
					}
				}
				break;

			case 3:
				System.out.print("Enter first name of contact to edit: ");
				String ef = input.nextLine();
				System.out.print("Enter last name of contact to edit: ");
				String el = input.nextLine();
				ContactPerson existing = contactService.getContactByName(ef, el);
				if (existing == null) {
					System.out.println("Contact not found.");
				} else {
					System.out.println("Enter new details:");
					ContactPerson updated = readContact(input);
					String updateMsg = contactService.updateContact(ef, el, updated);
					System.out.println(updateMsg);
				}
				break;

			case 4:
				System.out.print("Enter first name of contact to delete: ");
				String df = input.nextLine();
				System.out.print("Enter last name of contact to delete: ");
				String dl = input.nextLine();
				String delMsg = contactService.deleteContact(df, dl);
				System.out.println(delMsg);
				break;

			case 5:
				running = false;
				System.out.println("Exiting Address Book. Bye!");
				break;

			default:
				System.out.println("Invalid choice.");
			}
		}

		input.close();
	}

}
