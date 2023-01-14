package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.OwnerPetPrimaryKey;
import com.scaleupindia.exception.DuplicateOwnerException;
import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(OwnerPetPrimaryKey ownerPetPrimaryKey) throws OwnerNotFoundException;

	void updatePetDetails(OwnerPetPrimaryKey ownerPetPrimaryKey, String petName) throws OwnerNotFoundException;

	void deleteOwner(OwnerPetPrimaryKey ownerPetPrimaryKey) throws OwnerNotFoundException;
}