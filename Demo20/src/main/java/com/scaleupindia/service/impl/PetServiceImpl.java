package com.scaleupindia.service.impl;

import com.scaleupindia.repository.PetRepository;
import com.scaleupindia.repository.impl.PetRepositoryImpl;
import com.scaleupindia.service.PetService;

/**
 * @author abhishekvermaa10
 *
 */
public class PetServiceImpl implements PetService {
	private PetRepository petRepository;

	public PetServiceImpl() {
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public Double findAverageAgeOfPet() {
		return petRepository.findAverageAgeOfPet();
	}
}
