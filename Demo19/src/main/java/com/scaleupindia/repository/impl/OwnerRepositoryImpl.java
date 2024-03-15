package com.scaleupindia.repository.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.repository.OwnerRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public List<Owner> findAllOwners() {
		String hql = "SELECT o FROM Owner o JOIN FETCH o.pet";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Owner.class).getResultList();
		}
	}

	@Override
	public List<Owner> findAllOwnersByFirstNameInitials(String firstName) {
		String hql = "SELECT o FROM Owner o JOIN FETCH o.pet WHERE o.firstName LIKE CONCAT(:firstName,'%')";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Owner.class).setParameter("firstName", firstName).getResultList();
		}
	}

	@Override
	public List<Owner> findAllOwnersByPetDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
		String hql = "SELECT o FROM Owner o JOIN FETCH o.pet p WHERE p.birthDate BETWEEN :startDate AND :endDate ORDER BY p.birthDate";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Owner.class).setParameter("startDate", startDate)
					.setParameter("endDate", endDate).getResultList();
		}
	}

	@Override
	public List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize) {
		String hql = "SELECT o.id, o.firstName, o.lastName, p.name FROM Owner o JOIN o.pet p";
		try (Session session = sessionFactory.openSession()) {
			int skipSize = (pageNumber - 1) * pageSize;
			return session.createSelectionQuery(hql, Object[].class).setMaxResults(pageSize).setFirstResult(skipSize)
					.getResultList();
		}
	}
}
