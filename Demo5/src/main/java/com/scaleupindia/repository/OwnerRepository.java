package com.scaleupindia.repository;

import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.OwnerPetPrimaryKey;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(OwnerPetPrimaryKey ownerPetPrimaryKey);

	void updatePetDetails(OwnerPetPrimaryKey ownerPetPrimaryKey, String petName);

	void deleteOwner(OwnerPetPrimaryKey ownerPetPrimaryKey);
}
