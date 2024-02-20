package com.scaleupindia.service;

import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.exception.PetNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface PetService {
	PetDTO findPet(int petId) throws PetNotFoundException;
}