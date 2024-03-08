package com.scaleupindia.util;

import java.util.Scanner;

/**
 * @author abhishekvermaa10
 *
 */
public class InputUtil {
	private InputUtil() {

	}

	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to fetch owner details.");
		System.out.println("Press 2 to fetch pet details.");
		System.out.println("Press 3 to fetch all owners.");
		System.out.println("Press 4 to fetch all pets.");
		System.out.println("Press 5 to fetch all owners with pets.");
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

	public static int acceptOwnerIdToOperate(Scanner scanner) {
		System.out.println("Enter id of owner:");
		return scanner.nextInt();
	}

	public static int acceptPetIdToOperate(Scanner scanner) {
		System.out.println("Enter id of pet:");
		return scanner.nextInt();
	}
}
