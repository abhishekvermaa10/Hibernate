package com.scaleupindia.service.impl;

import java.util.Objects;

import com.scaleupindia.config.PropertiesConfig;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.exception.OwnerPetCombinationNotFoundException;
import com.scaleupindia.exception.PetNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.PetRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.repository.impl.PetRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	private static final String OWNER_NOT_FOUND = "owner.not.found";
	private static final String PET_NOT_FOUND = "pet.not.found";
	private static final String OWNER_PET_COMBINATION_NOT_FOUND = "owner.pet.combination.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		return MapperUtil.convertOwnerEntityToDtoWithoutPet(owner);
	}
	
	@Override
	public OwnerDTO findOwnerWithPet(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}
	
	@Override
	public void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException, OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new OwnerPetCombinationNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_NOT_FOUND), petId, ownerId));
		} else {
			ownerRepository.updatePetDetails(ownerId, petId, petName);
		}
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		ownerRepository.deleteOwner(ownerId);
	}
	
	@Override
	public void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		Pet pet = MapperUtil.convertPetDtoToEntity(petDTO);
		ownerRepository.addPet(ownerId, pet);
	}

	@Override
	public void removePet(int ownerId, int petId) throws OwnerNotFoundException, OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new OwnerPetCombinationNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_NOT_FOUND), petId, ownerId));
		} else {
			ownerRepository.removePet(ownerId, petId);
		}
	}
	
	@Override
	public void addCoOwner(int petId, OwnerDTO ownerDTO) throws PetNotFoundException {
		Pet pet = petRepository.findPet(petId);
		if (Objects.isNull(pet)) {
			throw new PetNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(PET_NOT_FOUND), petId));
		} else {
			Owner owner = MapperUtil.convertOwnerDtoToEntityWithoutPet(ownerDTO);
			ownerRepository.addCoOwner(petId, owner);
		}
	}
}
