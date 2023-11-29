package com.scaleupindia;

import java.util.Scanner;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import com.scaleupindia.util.InputUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();
	}

	public void run() {
		OwnerService ownerService = new OwnerServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
					ownerService.saveOwner(ownerDTO);
					System.out.println("Owner has been saved successfully.");
					break;
				case 2:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerDTO = ownerService.findOwner(ownerId);
					System.out.println("Owner has been fetched successfully.");
					System.out.println(ownerDTO);
					break;
				case 3:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetDetails(ownerId, petName);
					System.out.println("Pet details of owner have been updated successfully.");
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println("Owner has been deleted successfully.");
					break;
				default:
					System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
