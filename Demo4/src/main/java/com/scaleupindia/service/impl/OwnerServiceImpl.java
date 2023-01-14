package com.scaleupindia.service.impl;

import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
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
	public OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.updatePetDetails(UUID.fromString(ownerId), petName);
	}

	@Override
	public void deleteOwner(String ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.deleteOwner(UUID.fromString(ownerId));
	}
}
