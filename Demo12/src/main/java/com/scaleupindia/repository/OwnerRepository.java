package com.scaleupindia.repository;

import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(int ownerId);
	
	Owner findOwnerWithPet(int ownerId);
	
	void updatePetDetails(int ownerId, int petId, String petName);

	void deleteOwner(int ownerId);

	void addPet(int ownerId, Pet pet);

	void removePet(int ownerId, int petId);
	
	void addCoOwner(int petId, Owner owner);
}
