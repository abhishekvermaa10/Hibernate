package com.scaleupindia.service.impl;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
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

	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithoutHql(List<Integer> ownerIdList) {
		return ownerRepository.findSelectedOwnersWithoutHql(ownerIdList).stream()
				.map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithoutHqlV2(List<Integer> ownerIdList) {
		return ownerIdList.stream().map(ownerId -> {
			Owner owner = ownerRepository.findOwnerWithoutHql(ownerId);
			return MapperUtil.convertOwnerEntityToDto(owner);
		}).toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithHql(List<Integer> ownerIdList) {
		return ownerRepository.findSelectedOwnersWithHql(ownerIdList).stream().map(MapperUtil::convertOwnerEntityToDto)
				.toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithHqlV2(List<Integer> ownerIdList) {
		return ownerIdList.stream().map(ownerId -> {
			Owner owner = ownerRepository.findOwnerWithHql(ownerId);
			return MapperUtil.convertOwnerEntityToDto(owner);
		}).toList();
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners().stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}
}
