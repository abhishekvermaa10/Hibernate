package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.OwnerPetPrimaryKey;
import com.scaleupindia.exception.DuplicateOwnerPetCombinationException;
import com.scaleupindia.exception.OwnerPetCombinationNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerPetCombinationException;

	OwnerDTO findOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException;

	void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName) throws OwnerPetCombinationNotFoundException;

	void deleteOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException;
}