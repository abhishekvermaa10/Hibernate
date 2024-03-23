package com.scaleupindia.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author abhishekvermaa10
 *
 */
public class InputUtil {
	private InputUtil() {

	}

	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to fetch all owners.");
		System.out.println("Press 2 to fetch owner by initials of first name of owner.");
		System.out.println("Press 3 to fetch owner details whose pets born within a time period.");
		System.out.println("Press 4 to find average age of pet.");
		System.out.println("Press 5 to find specific details using pagination.");
		int menuOption = scanner.nextInt();
		if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5) {
			return menuOption;
		} else {
			return acceptMenuOption(scanner);
		}
	}

	public static boolean wantToContinue(Scanner scanner) {
		System.out.println("Press Y to continue and N to exit.");
		char choice = scanner.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}

	public static String acceptOwnerInititialsToOperate(Scanner scanner) {
		System.out.println("Enter initials of first name of owner:");
		return scanner.next();
	}

	public static LocalDate acceptFromPetBirthDateToOperate(Scanner scanner) {
		System.out.println("Enter start date of birth of pet (dd-MM-yyyy):");
		return convertStringToDate(scanner.next());
	}

	public static LocalDate acceptToPetBirthDateToOperate(Scanner scanner) {
		System.out.println("Enter end date of birth of pet (dd-MM-yyyy):");
		return convertStringToDate(scanner.next());
	}

	public static int acceptPageSizeToOperate(Scanner scanner) {
		System.out.println("Enter page size:");
		return scanner.nextInt();
	}

	public static int acceptPageNumberToOperate(Scanner scanner) {
		System.out.println("Enter page number:");
		return scanner.nextInt();
	}

	public static LocalDate convertStringToDate(String stringDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(stringDate, format);
	}
}
