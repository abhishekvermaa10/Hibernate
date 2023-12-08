package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException;

	void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(String ownerId) throws OwnerNotFoundException;
}