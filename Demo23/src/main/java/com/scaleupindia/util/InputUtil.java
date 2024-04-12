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
		System.out.println("Press 1 to to fetch selected owners as list using get() method");
		System.out.println("Press 2 to to fetch selected owners as individuals using get() method");
		System.out.println("Press 3 to to fetch selected owners as list using HQL");
		System.out.println("Press 4 to to fetch selected owners as individuals using HQL");
		System.out.println("Press 5 to fetch all owners.");
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
}
