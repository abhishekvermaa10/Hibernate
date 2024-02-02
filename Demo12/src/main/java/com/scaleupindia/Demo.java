package com.scaleupindia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.PetService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import com.scaleupindia.service.impl.PetServiceImpl;
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
		PetService petService = new PetServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
					PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
					List<PetDTO> petDTOList = new ArrayList<>();
					petDTOList.add(petDTO);
					ownerDTO.setPetDTOList(petDTOList);
					ownerService.saveOwner(ownerDTO);
					System.out.println("Owner has been saved successfully.");
					break;
				case 2:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerDTO = ownerService.findOwner(ownerId);
					System.out.println("Owner has been fetched successfully.");
					System.out.println(ownerDTO);
					ownerDTO = ownerService.findOwnerWithPet(ownerId);
					System.out.println("Owner with pets has been fetched successfully.");
					System.out.println(ownerDTO);
					break;
				case 3:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					int petId = InputUtil.acceptPetIdToOperate(scanner);
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetDetails(ownerId, petId, petName);
					System.out.println("Pet details of owner have been updated successfully.");
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println("Owner has been deleted successfully.");
					break;
				case 5:
					petId = InputUtil.acceptPetIdToOperate(scanner);
					petDTO = petService.findPet(petId);
					System.out.println("Pet has been fetched successfully.");
					System.out.println(petDTO);
					petDTO = petService.findPetWithOwner(petId);
					System.out.println("Pet with owner has been fetched successfully.");
					System.out.println(petDTO);
					break;
				case 6:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					petDTO = InputUtil.acceptPetDetailsToSave(scanner);
					ownerService.addPet(ownerId, petDTO);
					System.out.println("Pet has been added successfully.");
					break;
				case 7:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					petId = InputUtil.acceptPetIdToOperate(scanner);
					ownerService.removePet(ownerId, petId);
					System.out.println("Pet has been removed successfully.");
					break;
				case 8:
					ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
					petId = InputUtil.acceptPetIdToOperate(scanner);
					ownerService.addCoOwner(petId, ownerDTO);
					System.out.println("Co-owner has been added successfully.");
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
