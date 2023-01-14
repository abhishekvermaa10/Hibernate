package com.scaleupindia.service;

import java.time.LocalDate;
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

	List<OwnerDTO> findAllOwnersByFirstNameInitials(String firstName);

	OwnerDTO findOwnerByPetId(int petId) throws OwnerNotFoundException;

	List<OwnerDTO> findByAllOwnersByPetDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

	List<OwnerDTO> findAllOwnersByCity(List<String> cities);
}