package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException;

	public void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException;

	public void removePet(int ownerId, int petId) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;
}