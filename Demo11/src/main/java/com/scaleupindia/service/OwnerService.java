package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.exception.PetNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;
	
	OwnerDTO findOwnerWithPet(int ownerId) throws OwnerNotFoundException;
	
	void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException, PetNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;
	
	void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException;

	void deletePet(int ownerId, int petId) throws OwnerNotFoundException, PetNotFoundException;
}