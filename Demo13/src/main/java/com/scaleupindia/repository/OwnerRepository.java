package com.scaleupindia.repository;

import java.time.LocalDate;
import java.util.List;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(int ownerId);

	void updatePetDetails(int petId, String petName);

	void deleteOwner(int ownerId);

	List<Owner> findAllOwners();

	List<Owner> findAllOwnersByFirstNameInitials(String firstName);

	Owner findOwnerByPetId(int petId);

	List<Owner> findAllOwnersByPetDateOfBirthRange(LocalDate startDate, LocalDate endDate);

	List<Owner> findAllOwnersByCity(List<String> cities);
}
