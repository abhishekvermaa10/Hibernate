package com.scaleupindia.repository;

import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.OwnerPetPrimaryKey;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(OwnerPetPrimaryKey primaryKey);

	void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName);

	void deleteOwner(OwnerPetPrimaryKey primaryKey);
}
