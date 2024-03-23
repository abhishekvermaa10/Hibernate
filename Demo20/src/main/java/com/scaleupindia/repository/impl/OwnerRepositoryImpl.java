package com.scaleupindia.repository.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.repository.OwnerRepository;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public List<Owner> findAllOwners() {
		try (Session session = sessionFactory.openSession()) {
			HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Owner> criteriaQuery = hibernateCriteriaBuilder.createQuery(Owner.class);
			Root<Owner> root = criteriaQuery.from(Owner.class);
			root.fetch("pet");
			criteriaQuery.select(root);
			return session.createSelectionQuery(criteriaQuery).getResultList();
		}
	}

	@Override
	public List<Owner> findAllOwnersByFirstNameInitials(String firstName) {
		try (Session session = sessionFactory.openSession()) {
			HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Owner> criteriaQuery = hibernateCriteriaBuilder.createQuery(Owner.class);
			Root<Owner> root = criteriaQuery.from(Owner.class);
			root.fetch("pet");
			Predicate where = hibernateCriteriaBuilder.conjunction();
			where = hibernateCriteriaBuilder.and(where,
					hibernateCriteriaBuilder.like(root.get("firstName"), firstName + "%"));
			criteriaQuery.select(root).where(where);
			return session.createSelectionQuery(criteriaQuery).getResultList();
		}
	}

	@Override
	public List<Owner> findAllOwnersByPetDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
		try (Session session = sessionFactory.openSession()) {
			HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Owner> criteriaQuery = hibernateCriteriaBuilder.createQuery(Owner.class);
			Root<Owner> root = criteriaQuery.from(Owner.class);
			root.fetch("pet");
			Join<Owner, Pet> join = root.join("pet");
			Predicate where = hibernateCriteriaBuilder.conjunction();
			where = hibernateCriteriaBuilder.and(where,
					hibernateCriteriaBuilder.between(join.get("birthDate"), startDate, endDate));
			Order order = hibernateCriteriaBuilder.asc(join.get("birthDate"));
			criteriaQuery.select(root).where(where).orderBy(order);
			return session.createSelectionQuery(criteriaQuery).getResultList();
		}
	}

	@Override
	public List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize) {
		try (Session session = sessionFactory.openSession()) {
			HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = hibernateCriteriaBuilder.createQuery(Object[].class);
			Root<Owner> root = criteriaQuery.from(Owner.class);
			Join<Owner, Pet> join = root.join("pet");
			Selection<Object[]> selection = hibernateCriteriaBuilder.array(root.get("id"),
					root.get("firstName"), root.get("lastName"), join.get("name"));
			criteriaQuery.select(selection);
			int skipSize = (pageNumber - 1) * pageSize;
			return session.createSelectionQuery(criteriaQuery).setMaxResults(pageSize).setFirstResult(skipSize)
					.getResultList();
		}
	}
}
