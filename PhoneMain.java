//Finn Parker
//2.3.21
//CS145 - Assignment 2 - Phone book
//Darrell Criss
//Guides the user through the phone book program

import java.util.Scanner;

public class PhoneMain {
	public static void main(String[] args) {
		// Dummy node
		PhoneNode contacts = new PhoneNode();
		Scanner sc = new Scanner(System.in);
		boolean more2Do = true;
		// Main Menu
		System.out.println("Welcome to your phonebook manager");
		while (more2Do) {

			System.out.println("Enter 'a' to add an entry to your phonebook");
			System.out.println("Enter 'm' to modify an entry in your phonebook");
			System.out.println("Enter 'd' to delete an entry from your phonebook");
			System.out.println("Enter 's' to sort the contacts in your phonebook");
			System.out.println("Enter 'p' to see the contacts in your phonebook");
			System.out.println("Enter 'q' to quit");
			String b4Arr = sc.nextLine();
			char[] cArr = b4Arr.toLowerCase().toCharArray();
			if (cArr[0] == 'a') {
				PhoneManager.add(contacts);
			} else if (cArr[0] == 'm') {
				PhoneManager.modify(contacts);
			} else if (cArr[0] == 'd') {
				PhoneManager.delete(contacts);
			} else if (cArr[0] == 'p') {
				PhoneManager.print(contacts);
			} else if (cArr[0] == 'q') {
				System.out.println("Closing phonebook...");
				more2Do = false;
			} else if (cArr[0] == 's') {
				System.out.println("Enter f to sort by first name");
				System.out.println("Enter l to sort by last name");
				b4Arr = sc.nextLine();
				cArr = b4Arr.toLowerCase().toCharArray();
				if (cArr[0] == 'f') {
					PhoneManager.sort(contacts, 'f');
				} else if (cArr[0] == 'l') {
					PhoneManager.sort(contacts, 'l');
				}

			} else {
				System.out.println("Sorry! That wasn't an option. Please try again.");
				System.out.println();
			}
		}
	}
}