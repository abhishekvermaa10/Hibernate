package com.scaleupindia.repository;

import java.util.List;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	List<Owner> findSelectedOwnersWithoutHql(List<Integer> ownerIdList);

	Owner findOwnerWithoutHql(Integer ownerId);

	List<Owner> findSelectedOwnersWithHql(List<Integer> ownerIdList);

	Owner findOwnerWithHql(Integer ownerId);
}
