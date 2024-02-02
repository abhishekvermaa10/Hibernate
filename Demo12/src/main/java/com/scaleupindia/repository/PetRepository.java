package com.scaleupindia.repository;

import com.scaleupindia.entity.Pet;

/**
 * @author abhishekvermaa10
 *
 */
public interface PetRepository {
	Pet findPet(int petId);

	Pet findPetWithOwner(int petId);
}
