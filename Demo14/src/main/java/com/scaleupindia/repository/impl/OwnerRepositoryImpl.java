package com.scaleupindia.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.scaleupindia.config.HibernateConfiguration;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.enums.Gender;
import com.scaleupindia.repository.OwnerRepository;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

	@Override
	public void saveOwner(Owner owner) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(owner);
		transaction.commit();
		session.close();
	}

	@Override
	public Owner findOwner(int ownerId) {
		Session session = sessionFactory.openSession();
		Owner owner = session.get(Owner.class, ownerId);
		session.close();
		return owner;
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Owner owner = session.get(Owner.class, ownerId);
		owner.getPet().setName(petName);
		session.merge(owner);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteOwner(int ownerId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Owner owner = session.get(Owner.class, ownerId);
		session.remove(owner);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Owner> findAllOwners() {
		String sql = "SELECT o FROM Owner o";
		Session session = sessionFactory.openSession();
		Query<Owner> query = session.createQuery(sql, Owner.class);
		List<Owner> ownerList = query.list();
		session.close();
		return ownerList;
	}

	@Override
	public List<Owner> findAllOwnersWithCriteraOnGenderAndCity(String maleOwnerCity, String femaleOwnerCity) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);

		Root<Owner> root = criteriaQuery.from(Owner.class);

		Predicate subPredicate1 = criteriaBuilder.equal(root.get("gender"), Gender.M);
		Predicate subPredicate2 = criteriaBuilder.equal(root.get("city"), maleOwnerCity);
		Predicate predicate1 = criteriaBuilder.and(subPredicate1, subPredicate2);

		Predicate subPredicate3 = criteriaBuilder.equal(root.get("gender"), Gender.F);
		Predicate subPredicate4 = criteriaBuilder.equal(root.get("city"), femaleOwnerCity);
		Predicate predicate2 = criteriaBuilder.and(subPredicate3, subPredicate4);

		criteriaQuery.where(criteriaBuilder.or(predicate1, predicate2));

		Query<Owner> query = session.createQuery(criteriaQuery.select(root));
		List<Owner> ownerList = query.getResultList();
		session.close();
		return ownerList;
	}

	@Override
	public List<Owner> findAllOwnersWithCriteraOnNotEqualOwnerPetGender() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);

		Root<Owner> root = criteriaQuery.from(Owner.class);
		Join<Owner, Pet> join = root.join("pet");

		Predicate predicate = criteriaBuilder.notEqual(root.get("gender"), join.get("gender"));

		criteriaQuery.where(predicate);
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));

		Query<Tuple> query = session.createQuery(criteriaQuery.multiselect(root, join));
		List<Tuple> tupleList = query.getResultList();
		List<Owner> ownerList = tupleList.stream().map(tuple -> tuple.get(0, Owner.class)).toList();
		session.close();
		return ownerList;
	}
}
