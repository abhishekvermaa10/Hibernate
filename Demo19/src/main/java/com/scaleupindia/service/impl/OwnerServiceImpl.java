package com.scaleupindia.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
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
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners().stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findAllOwnersByFirstNameInitials(String firstName) {
		return ownerRepository.findAllOwnersByFirstNameInitials(firstName).stream()
				.map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findByAllOwnersByPetDateOfBirthBetween(LocalDate startDate, LocalDate endDate) {
		return ownerRepository.findAllOwnersByPetDateOfBirthRange(startDate, endDate).stream()
				.map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize) {
		return ownerRepository.findIdAndFirstNameAndLastNameAndPetName(pageNumber, pageSize);
	}
}
