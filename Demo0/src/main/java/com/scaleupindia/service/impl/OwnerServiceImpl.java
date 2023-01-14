package com.scaleupindia.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.DuplicateOwnerException;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private Properties properties;
	private static final String OWNER_ALREADY_EXISTS = "owner.already.exists";
	private static final String OWNER_NOT_FOUND = "owner.not.found";

	public OwnerServiceImpl(Properties properties) {
		this.ownerRepository = new OwnerRepositoryImpl(properties);
		this.properties = properties;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {
		OwnerDTO existingOwner = ownerRepository.findOwner(ownerDTO.getId());
		if (Objects.nonNull(existingOwner)) {
			throw new DuplicateOwnerException(properties.getProperty(OWNER_ALREADY_EXISTS) + ownerDTO.getId());
		}
		ownerRepository.saveOwner(ownerDTO);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		return owner;
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.updatePetDetails(ownerId, petName);
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.deleteOwner(ownerId);
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners();
	}
}
