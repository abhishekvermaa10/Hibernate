package com.scaleupindia.util;

import com.scaleupindia.dto.DomesticPetDTO;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.dto.WildPetDTO;
import com.scaleupindia.entity.DomesticPet;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.entity.WildPet;

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
		PetDTO petDTO = convertPetEntityToDto(owner.getPet());
		ownerDTO.setPetDTO(petDTO);
		return ownerDTO;
	}

	public static PetDTO convertPetEntityToDto(Pet pet) {
		PetDTO petDTO = null;
		if (pet instanceof DomesticPet domesticPet) {
			DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
			domesticPetDTO.setId(domesticPet.getId());
			domesticPetDTO.setName(domesticPet.getName());
			domesticPetDTO.setBirthDate(domesticPet.getBirthDate());
			domesticPetDTO.setGender(domesticPet.getGender());
			domesticPetDTO.setType(domesticPet.getType());
			petDTO = domesticPetDTO;
		} else if (pet instanceof WildPet wildPet) {
			WildPetDTO wildPetDTO = new WildPetDTO();
			wildPetDTO.setId(wildPet.getId());
			wildPetDTO.setName(wildPet.getName());
			wildPetDTO.setBirthPlace(wildPet.getBirthPlace());
			wildPetDTO.setGender(wildPet.getGender());
			wildPetDTO.setType(wildPet.getType());
			petDTO = wildPetDTO;
		}
		return petDTO;
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
		Pet pet = null;
		if (petDTO instanceof DomesticPetDTO domesticPetDTO) {
			DomesticPet domesticPet = new DomesticPet();
			domesticPet.setName(domesticPetDTO.getName());
			domesticPet.setBirthDate(domesticPetDTO.getBirthDate());
			domesticPet.setGender(domesticPetDTO.getGender());
			domesticPet.setType(domesticPetDTO.getType());
			pet = domesticPet;
		} else if (petDTO instanceof WildPetDTO wildPetDTO) {
			WildPet wildPet = new WildPet();
			wildPet.setName(wildPetDTO.getName());
			wildPet.setBirthPlace(wildPetDTO.getBirthPlace());
			wildPet.setGender(wildPetDTO.getGender());
			wildPet.setType(wildPetDTO.getType());
			pet = wildPet;
		}
		return pet;
	}
}
