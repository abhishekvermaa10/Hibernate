package com.scaleupindia.service.impl;

import java.util.Objects;

import com.scaleupindia.config.PropertiesConfig;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.exception.PetNotFoundException;
import com.scaleupindia.repository.PetRepository;
import com.scaleupindia.repository.impl.PetRepositoryImpl;
import com.scaleupindia.service.PetService;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class PetServiceImpl implements PetService {
	private PetRepository petRepository;
	private static final String PET_NOT_FOUND = "pet.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	public PetServiceImpl() {
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		Pet pet = petRepository.findPet(petId);
		if (Objects.isNull(pet)) {
			throw new PetNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(PET_NOT_FOUND), petId));
		}
		return MapperUtil.convertPetEntityToDto(pet);
	}
}
