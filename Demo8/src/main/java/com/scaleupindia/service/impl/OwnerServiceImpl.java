package com.scaleupindia.service.impl;

import java.util.Objects;
import java.util.Properties;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private Properties properties;
	private static final String OWNER_NOT_FOUND = "owner.not.found";

	public OwnerServiceImpl(Properties properties) {
		this.ownerRepository = new OwnerRepositoryImpl();
		this.properties = properties;
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
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.updatePetDetails(ownerId, petId, petName);
	}

	@Override
	public void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		Pet pet = MapperUtil.convertPetDtoToEntity(petDTO);
		ownerRepository.addPet(ownerId, pet);
	}

	@Override
	public void removePet(int ownerId, int petId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.removePet(ownerId, petId);
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.deleteOwner(ownerId);
	}
}
