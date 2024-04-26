package com.scaleupindia.repository.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.Hibernate;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.repository.OwnerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private EntityManagerFactory entityManagerFactory = DatabaseConfig.getEntityManagerFactory();

	@Override
	public void saveOwner(Owner owner) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(owner);
			entityTransaction.commit();
		}
	}

	@Override
	public Owner findOwner(int ownerId) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			Owner owner = entityManager.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				Pet pet = Hibernate.unproxy(owner.getPet(), Pet.class);
				owner.setPet(pet);
			}
			return owner;
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Owner owner = entityManager.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				owner.getPet().setName(petName);
				entityManager.merge(owner);
			}
			entityTransaction.commit();
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Owner owner = entityManager.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				entityManager.remove(owner);
			}
			entityTransaction.commit();
		}
	}

	@Override
	public List<Owner> findAllOwners() {
		String jpql = "SELECT o FROM Owner o JOIN FETCH o.pet";
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			return entityManager.createQuery(jpql, Owner.class).getResultList();
		}
	}

	@Override
	public List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
			Root<Owner> root = criteriaQuery.from(Owner.class);
			Join<Owner, Pet> join = root.join("pet");
			Selection<Object[]> selection = criteriaBuilder.array(root.get("id"), root.get("firstName"),
					root.get("lastName"), join.get("name"));
			criteriaQuery.select(selection);
			int skipSize = (pageNumber - 1) * pageSize;
			return entityManager.createQuery(criteriaQuery).setMaxResults(pageSize).setFirstResult(skipSize)
					.getResultList();
		}
	}
}
