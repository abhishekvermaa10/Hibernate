package com.scaleupindia.service.impl;

import java.util.Objects;

import com.scaleupindia.config.PropertiesConfig;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.OwnerPetPrimaryKey;
import com.scaleupindia.exception.DuplicateOwnerPetCombinationException;
import com.scaleupindia.exception.OwnerPetCombinationNotFoundException;
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
	private static final String OWNER_PET_COMBINATION_ALREADY_EXISTS = "owner.pet.combination.already.exists";
	private static final String OWNER_PET_COMBINATION_NOT_FOUND = "owner.pet.combination.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerPetCombinationException {
		OwnerPetPrimaryKey primaryKey = new OwnerPetPrimaryKey();
		primaryKey.setId(ownerDTO.getId());
		primaryKey.setPetId(ownerDTO.getPetId());
		Owner existingOwner = ownerRepository.findOwner(primaryKey);
		if (Objects.nonNull(existingOwner)) {
			throw new DuplicateOwnerPetCombinationException(
					String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_ALREADY_EXISTS), ownerDTO.getId(), ownerDTO.getPetId()));
		}
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);
	}

	@Override
	public OwnerDTO findOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new OwnerPetCombinationNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_NOT_FOUND), primaryKey.getId(), primaryKey.getPetId()));
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new OwnerPetCombinationNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_NOT_FOUND), primaryKey.getId(), primaryKey.getPetId()));
		}
		ownerRepository.updatePetDetails(primaryKey, petName);
	}

	@Override
	public void deleteOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new OwnerPetCombinationNotFoundException(String.format(PROPERTIES_CONFIG.getProperty(OWNER_PET_COMBINATION_NOT_FOUND), primaryKey.getId(), primaryKey.getPetId()));
		}
		ownerRepository.deleteOwner(primaryKey);
	}
}
