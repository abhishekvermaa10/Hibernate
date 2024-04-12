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
		PetDTO petDTO = convertPetEntityToDtoWithoutOwner(owner.getPet());
		ownerDTO.setPetDTO(petDTO);
		return ownerDTO;
	}

	private static PetDTO convertPetEntityToDtoWithoutOwner(Pet pet) {
		PetDTO petDTO = null;
		if (pet instanceof DomesticPet domesticPet) {
			petDTO = new DomesticPetDTO();
			((DomesticPetDTO) petDTO).setBirthDate(domesticPet.getBirthDate());
		} else if (pet instanceof WildPet wildPet) {
			petDTO = new WildPetDTO();
			((WildPetDTO) petDTO).setBirthPlace(wildPet.getBirthPlace());
		} else {
			throw new IllegalArgumentException("Unsupported pet instance: " + pet.getClass());
		}
		petDTO.setId(pet.getId());
		petDTO.setName(pet.getName());
		petDTO.setGender(pet.getGender());
		petDTO.setType(pet.getType());
		return petDTO;
	}
}
