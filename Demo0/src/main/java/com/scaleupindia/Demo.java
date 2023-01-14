package com.scaleupindia;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
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
	private OwnerService ownerService;
	private Properties properties;
	private static final String GREETINGS_MESSAGE = "greetings.message";
	private static final String OWNER_SAVED = "owner.saved";
	private static final String OWNER_FOUND = "owner.found";
	private static final String OWNER_UPDATED = "owner.pet.updated";
	private static final String OWNER_REMOVED = "owner.removed";
	private static final String INVALID_OPTION = "invalid.option";

	public static void main(String[] args) throws IOException {
		Demo demo = new Demo();
		demo.loadProperties();
		demo.run(args);
	}

	public Properties loadProperties() throws IOException {
		try (FileReader fileReader1 = new FileReader("src/main/resources/database.properties");
				FileReader fileReader2 = new FileReader("src/main/resources/messages.properties");) {
			properties = new Properties();
			properties.load(fileReader1);
			properties.load(fileReader2);
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
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetDetails(ownerId, petName);
					System.out.println(properties.getProperty(OWNER_UPDATED));
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println(properties.getProperty(OWNER_REMOVED));
					break;
				case 5:
					List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
					System.out.println("There are " + ownerDTOList.size() + " owners.");
					ownerDTOList.forEach(System.out::println);
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
