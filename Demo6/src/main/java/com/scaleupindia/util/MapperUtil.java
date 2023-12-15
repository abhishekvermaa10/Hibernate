package com.scaleupindia.util;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.OwnerPetPrimaryKey;

/**
 * @author abhishekvermaa10
 *
 */
public class MapperUtil {
	private MapperUtil() {

	}

	public static OwnerDTO convertOwnerEntityToDto(Owner owner) {
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId(owner.getPrimaryKey().getId());
		ownerDTO.setFirstName(owner.getFirstName());
		ownerDTO.setLastName(owner.getLastName());
		ownerDTO.setGender(owner.getGender());
		ownerDTO.setCity(owner.getCity());
		ownerDTO.setState(owner.getState());
		ownerDTO.setMobileNumber(owner.getMobileNumber());
		ownerDTO.setEmailId(owner.getEmailId());
		ownerDTO.setPetId(owner.getPrimaryKey().getPetId());
		ownerDTO.setPetName(owner.getPetName());
		ownerDTO.setPetBirthDate(owner.getPetBirthDate());
		ownerDTO.setPetGender(owner.getPetGender());
		ownerDTO.setPetType(owner.getPetType());
		return ownerDTO;
	}

	public static Owner convertOwnerDtoToEntity(OwnerDTO ownerDTO) {
		Owner owner = new Owner();
		OwnerPetPrimaryKey primaryKey = new OwnerPetPrimaryKey();
		primaryKey.setId(ownerDTO.getId());
		primaryKey.setPetId(ownerDTO.getPetId());
		owner.setPrimaryKey(primaryKey);
		owner.setFirstName(ownerDTO.getFirstName());
		owner.setLastName(ownerDTO.getLastName());
		owner.setGender(ownerDTO.getGender());
		owner.setCity(ownerDTO.getCity());
		owner.setState(ownerDTO.getState());
		owner.setMobileNumber(ownerDTO.getMobileNumber());
		owner.setEmailId(ownerDTO.getEmailId());
		owner.setPetName(ownerDTO.getPetName());
		owner.setPetBirthDate(ownerDTO.getPetBirthDate());
		owner.setPetGender(ownerDTO.getPetGender());
		owner.setPetType(ownerDTO.getPetType());
		return owner;
	}
}
