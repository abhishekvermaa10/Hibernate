package com.scaleupindia.repository;

import java.util.UUID;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(UUID ownerId);

	void updatePetDetails(UUID ownerId, String petName);

	void deleteOwner(UUID ownerId);
}
