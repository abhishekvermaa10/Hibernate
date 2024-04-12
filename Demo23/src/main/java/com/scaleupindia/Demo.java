package com.scaleupindia;

import java.util.List;
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
					List<OwnerDTO> ownerDTOList = ownerService.findSelectedOwnersWithoutHql(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Primary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 2:
					ownerDTOList = ownerService.findSelectedOwnersWithoutHqlV2(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Secondary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 3:
					ownerDTOList = ownerService.findSelectedOwnersWithHql(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Primary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 4:
					ownerDTOList = ownerService.findSelectedOwnersWithHqlV2(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Secondary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 5:
					ownerDTOList = ownerService.findAllOwners();
					System.out.println("There are " + ownerDTOList.size() + " owners.");
					ownerDTOList.forEach(System.out::println);
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