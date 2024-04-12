package com.scaleupindia.service;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	List<OwnerDTO> findSelectedOwnersWithoutHql(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithoutHqlV2(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithHql(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithHqlV2(List<Integer> ownerIdList);

	List<OwnerDTO> findAllOwners();
}