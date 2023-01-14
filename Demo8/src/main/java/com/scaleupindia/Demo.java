package com.scaleupindia;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import com.scaleupindia.util.InputUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	private OwnerService ownerService;
	private Properties properties;
	private static final String GREETINGS_MESSAGE = "greetings.message";
	private static final String OWNER_SAVED = "owner.saved";
	private static final String OWNER_FOUND = "owner.found";
	private static final String OWNER_UPDATED = "owner.pet.updated";
	private static final String OWNER_REMOVED = "owner.removed";
	private static final String PET_ADDED = "pet.added";
	private static final String PET_REMOVED = "pet.removed";
	private static final String INVALID_OPTION = "invalid.option";

	public static void main(String[] args) throws IOException {
		Demo demo = new Demo();
		demo.loadProperties();
		demo.run(args);
	}

	public Properties loadProperties() throws IOException {
		try (FileReader fileReader = new FileReader("src/main/resources/messages.properties");) {
			properties = new Properties();
			properties.load(fileReader);
			return properties;
		}
	}

	public void run(String... args) {
		ownerService = new OwnerServiceImpl(properties);
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println(properties.getProperty(GREETINGS_MESSAGE));
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
					PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
					List<PetDTO> petDTOList = new ArrayList<>();
					petDTOList.add(petDTO);
					ownerDTO.setPetDTOList(petDTOList);
					ownerService.saveOwner(ownerDTO);
					System.out.println(properties.getProperty(OWNER_SAVED));
					break;
				case 2:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerDTO = ownerService.findOwner(ownerId);
					System.out.println(properties.getProperty(OWNER_FOUND));
					System.out.println(ownerDTO);
					break;
				case 3:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					int petId = InputUtil.acceptPetIdToOperate(scanner);
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetDetails(ownerId, petId, petName);
					System.out.println(properties.getProperty(OWNER_UPDATED));
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println(properties.getProperty(OWNER_REMOVED));
					break;
				case 5:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					petDTO = InputUtil.acceptPetDetailsToSave(scanner);
					ownerService.addPet(ownerId, petDTO);
					System.out.println(properties.getProperty(PET_ADDED));
					break;
				case 6:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					petId = InputUtil.acceptPetIdToOperate(scanner);
					ownerService.removePet(ownerId, petId);
					System.out.println(properties.getProperty(PET_REMOVED));
					break;
				default:
					System.out.println(properties.getProperty(INVALID_OPTION));
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
