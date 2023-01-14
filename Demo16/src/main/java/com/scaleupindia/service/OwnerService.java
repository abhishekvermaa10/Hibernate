package com.scaleupindia.service;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();
	
	List<OwnerDTO> findAllOwnersV2();

	List<OwnerDTO> findAllOwnersWithIds(List<Integer> ownerIdList);
	
	List<OwnerDTO> findAllOwnersWithIdsV2(List<Integer> ownerIdList);
}