package com.scaleupindia.repository.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public List<Owner> findSelectedOwnersWithoutHql(List<Integer> ownerIdList) {
		try (Session session = sessionFactory.openSession()) {
			return ownerIdList.stream().map(ownerId -> {
				Owner owner = session.get(Owner.class, ownerId);
				if (Objects.nonNull(owner)) {
					Pet pet = Hibernate.unproxy(owner.getPet(), Pet.class);
					owner.setPet(pet);
				}
				return owner;
			}).toList();
		}
	}

	@Override
	public Owner findOwnerWithoutHql(Integer ownerId) {
		try (Session session = sessionFactory.openSession()) {
			Owner owner = session.get(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				Pet pet = Hibernate.unproxy(owner.getPet(), Pet.class);
				owner.setPet(pet);
			}
			return owner;
		}
	}

	@Override
	public List<Owner> findSelectedOwnersWithHql(List<Integer> ownerIdList) {
		String sql = "SELECT o FROM Owner o JOIN FETCH o.pet WHERE o.id = :ownerId";
		try (Session session = sessionFactory.openSession()) {
			return ownerIdList.stream().map(ownerId -> session.createQuery(sql, Owner.class)
					.setParameter("ownerId", ownerId).setCacheable(true).getSingleResultOrNull()).toList();
		}
	}

	@Override
	public Owner findOwnerWithHql(Integer ownerId) {
		String sql = "SELECT o FROM Owner o JOIN FETCH o.pet WHERE o.id = :ownerId";
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery(sql, Owner.class).setParameter("ownerId", ownerId).setCacheable(true).getSingleResultOrNull();
		}
	}
	
	@Override
	public List<Owner> findAllOwners() {
		String sql = "SELECT o FROM Owner o JOIN FETCH o.pet";
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery(sql, Owner.class).setCacheable(true).getResultList();
		}
	}
}
