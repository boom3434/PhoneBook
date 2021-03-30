//Finn Parker
//2.3.21
//CS145 - Assignment #2 - Phone Book
//Darrell Criss
//Handles all methods (sort,add,print,modify, delete) for the phonebook

import java.util.*;

public class PhoneManager {
	static PhoneNode sorted;
	
	//adds a new contact to the phoneBook
	public static void add(PhoneNode contacts) {
		Scanner sc = new Scanner(System.in);
		// get to front
		PhoneNode current = contacts;

		while (current.next != null) {
			current = current.next;
		}
		current.next = new PhoneNode();
		System.out.println("Enter the new contact's first name:");
		String fName = sc.nextLine();
		current.next.fName = fName;
		System.out.println("Enter the new contact's last name:");
		String lName = sc.nextLine();
		current.next.lName = lName;
		System.out.println("Enter the new contact's phone number:");
		String number = sc.nextLine();
		current.next.phoneNum = number;
		System.out.println("Enter the new contact's address:");
		String address = sc.nextLine();
		current.next.address = address;
		System.out.println("Enter the new contact's city:");
		String city = sc.nextLine();
		current.next.city = city;
		System.out.println();

		
	}
	//prints the contents of the phone book
	public static void print(PhoneNode contacts) {
		PhoneNode current = contacts;
		while (current.next != null) {
			current = current.next;
			System.out.println("First Name: " + current.fName);
			System.out.println("Last Name: " + current.lName);
			System.out.println("Phone Number: " + current.phoneNum);
			System.out.println("Address: " + current.address);
			System.out.println("City: " + current.city);
			System.out.println();
		}
	}
	//modifies a contact in the phone book
	public static void modify(PhoneNode contacts) {
		Scanner sc = new Scanner(System.in);
		PhoneNode current = contacts.next;
		PhoneNode contact = null;
		System.out.println("Enter the first name of the contact you'd like to modify:");
		String searchName = sc.nextLine();
		while (current != null) {
			if (current.fName.equalsIgnoreCase(searchName)) {
				contact = current;
			}
			current = current.next;
		}
		if (contact.fName.equalsIgnoreCase(searchName)) {
			System.out.println("I found the contact named: " + searchName + ".");
			System.out.println("Enter 'f' to modify " + searchName + "'s first name");
			System.out.println("Enter 'l' to modify " + searchName + "'s last name");
			System.out.println("Enter 'p' to modify " + searchName + "'s phone number");
			System.out.println("Enter 'a' to modify " + searchName + "'s address");
			System.out.println("Enter 'c' to modify " + searchName + "'s city");
			String choice = sc.nextLine();
			char[] choiceArr = choice.toLowerCase().toCharArray();
			if (choiceArr[0] == 'f') {
				System.out.println("Enter " + searchName + "'s new first name:");
				String newfName = sc.nextLine();
				contact.fName = newfName;
			} else if (choiceArr[0] == 'l') {
				System.out.println("Enter " + searchName + "'s new last name:");
				String newlName = sc.nextLine();
				contact.lName = newlName;
			} else if (choiceArr[0] == 'p') {
				System.out.println("Enter " + searchName + "'s new phone number:");
				String newNum = sc.nextLine();
				contact.phoneNum = newNum;
			} else if (choiceArr[0] == 'a') {
				System.out.println("Enter " + searchName + "'s new address:");
				String newAddress = sc.nextLine();
				contact.address = newAddress;
			} else if (choiceArr[0] == 'c') {
				System.out.println("Enter " + searchName + "'s new city:");
				String newCity = sc.nextLine();
				contact.city = newCity;
			} else {
				System.out.println("Sorry! That wasn't one of the available options.");
			}

		} else {
			System.out.println("I wasn't able to find any contacts named " + searchName + ".");
			System.out.println();
		}

	}
	//sorts the phone book by first or last name
	public static void sort(PhoneNode contacts, char choice) {
		sorted = null;
		PhoneNode current = contacts.next;

		while (current != null) {
			PhoneNode next = current.next;
			sortInsert(current, choice);
			current = next;
		}
		contacts.next = sorted;
	}

	// deletes a contact from the phone book
	public static void delete(PhoneNode contacts) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name of the contact you want to delete:");
		String deleteName = sc.nextLine();
		deleteName = deleteName.toLowerCase();
		PhoneNode current = contacts.next;
		System.out.println("Current name: " + current.fName);
		PhoneNode prev = contacts;
		System.out.println("Prev name: " + prev.fName);
		if (current != null && current.fName.equalsIgnoreCase(deleteName)) {
			System.out.println("Entered delete first if");
			contacts.next = current.next;
			return;
		}

		while (current != null && !(current.fName.equalsIgnoreCase(deleteName))) {
			prev = current;
			current = current.next;
		}
		if (current == null) {
			System.out.println("I couldn't find any contacts named " + deleteName + ".");
			return;
		}
		prev.next = current.next;
	}
	//helps the sort method complete sorting
	private static void sortInsert(PhoneNode newNode, char choice) {
		if (choice == 'f') {
			if (sorted == null || sorted.fName.toLowerCase().charAt(0) >= newNode.fName.toLowerCase().charAt(0)) {
				newNode.next = sorted;
				sorted = newNode;
			} else {
				PhoneNode current = sorted;

				while (current.next != null
						&& current.next.fName.toLowerCase().charAt(0) < newNode.fName.toLowerCase().charAt(0)) {
					current = current.next;
				}
				newNode.next = current.next;
				current.next = newNode;
			}
		} else {
			if (sorted == null || sorted.lName.toLowerCase().charAt(0) >= newNode.lName.toLowerCase().charAt(0)) {
				newNode.next = sorted;
				sorted = newNode;
			} else {
				PhoneNode current = sorted;

				while (current.next != null
						&& current.next.lName.toLowerCase().charAt(0) < newNode.lName.toLowerCase().charAt(0)) {
					current = current.next;
				}
				newNode.next = current.next;
				current.next = newNode;
			}
		}
	}
}