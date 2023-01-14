package com.scaleupindia.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

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
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.updatePetDetails(owner.getPet().getId(), petName);
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(properties.getProperty(OWNER_NOT_FOUND) + ownerId);
		}
		ownerRepository.deleteOwner(ownerId);
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners().stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findAllOwnersWithIds(List<Integer> ownerIdList) {
		return ownerRepository.findAllOwnersWithIds(ownerIdList).stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findAllOwnersWithIdsV2(List<Integer> ownerIdList) {
		return ownerIdList.stream().map(ownerId -> {
			Owner owner = ownerRepository.findOwner(ownerId);
			return MapperUtil.convertOwnerEntityToDto(owner);
		}).toList();
	}
}
