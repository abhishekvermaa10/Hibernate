package com.scaleupindia.repository;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(int ownerId);

	void updatePetDetailsUsingPersistentState(int ownerId, String petName);

	void updatePetDetailsUsingDetachedState(int ownerId, String petName);

	void deleteOwner(int ownerId);
}
