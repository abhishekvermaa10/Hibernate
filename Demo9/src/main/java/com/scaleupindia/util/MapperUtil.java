package com.scaleupindia.util;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;

/**
 * @author abhishekvermaa10
 *
 */
public class MapperUtil {
	private MapperUtil() {

	}

	public static OwnerDTO convertOwnerEntityToDto(Owner owner) {
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId(owner.getId());
		ownerDTO.setFirstName(owner.getFirstName());
		ownerDTO.setLastName(owner.getLastName());
		ownerDTO.setGender(owner.getGender());
		ownerDTO.setCity(owner.getCity());
		ownerDTO.setState(owner.getState());
		ownerDTO.setMobileNumber(owner.getMobileNumber());
		ownerDTO.setEmailId(owner.getEmailId());
		PetDTO petDTO = convertPetEntityToDtoWithoutOwner(owner.getPet());
		ownerDTO.setPetDTO(petDTO);
		return ownerDTO;
	}

	private static PetDTO convertPetEntityToDtoWithoutOwner(Pet pet) {
		PetDTO petDTO = new PetDTO();
		petDTO.setId(pet.getId());
		petDTO.setName(pet.getName());
		petDTO.setBirthDate(pet.getBirthDate());
		petDTO.setGender(pet.getGender());
		petDTO.setType(pet.getType());
		return petDTO;
	}

	public static PetDTO convertPetEntityToDto(Pet pet) {
		PetDTO petDTO = new PetDTO();
		petDTO.setId(pet.getId());
		petDTO.setName(pet.getName());
		petDTO.setBirthDate(pet.getBirthDate());
		petDTO.setGender(pet.getGender());
		petDTO.setType(pet.getType());
		OwnerDTO ownerDTO = convertOwnerEntityToDtoWithoutPet(pet.getOwner());
		petDTO.setOwnerDTO(ownerDTO);
		return petDTO;
	}

	private static OwnerDTO convertOwnerEntityToDtoWithoutPet(Owner owner) {
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId(owner.getId());
		ownerDTO.setFirstName(owner.getFirstName());
		ownerDTO.setLastName(owner.getLastName());
		ownerDTO.setGender(owner.getGender());
		ownerDTO.setCity(owner.getCity());
		ownerDTO.setState(owner.getState());
		ownerDTO.setMobileNumber(owner.getMobileNumber());
		ownerDTO.setEmailId(owner.getEmailId());
		return ownerDTO;
	}

	public static Owner convertOwnerDtoToEntity(OwnerDTO ownerDTO) {
		Owner owner = new Owner();
		owner.setFirstName(ownerDTO.getFirstName());
		owner.setLastName(ownerDTO.getLastName());
		owner.setGender(ownerDTO.getGender());
		owner.setCity(ownerDTO.getCity());
		owner.setState(ownerDTO.getState());
		owner.setMobileNumber(ownerDTO.getMobileNumber());
		owner.setEmailId(ownerDTO.getEmailId());
		Pet pet = convertPetDtoToEntity(ownerDTO.getPetDTO());
		owner.setPet(pet);
		return owner;
	}

	public static Pet convertPetDtoToEntity(PetDTO petDTO) {
		Pet pet = new Pet();
		pet.setName(petDTO.getName());
		pet.setBirthDate(petDTO.getBirthDate());
		pet.setGender(petDTO.getGender());
		pet.setType(petDTO.getType());
		return pet;
	}

}
