package com.scaleupindia.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.scaleupindia.config.HibernateConfiguration;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.repository.OwnerRepository;

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
		String sql = "SELECT o FROM Owner o WHERE o.id = :ownerId";
		Session session = sessionFactory.openSession();
		Query<Owner> query = session.createQuery(sql, Owner.class);
		query.setParameter("ownerId", ownerId);
		Owner owner = query.uniqueResult();
		session.close();
		return owner;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public void updatePetDetails(int petId, String petName) {
		String sql = "UPDATE Pet p SET p.name = :petName WHERE p.id = :petId";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setParameter("petName", petName);
		query.setParameter("petId", petId);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public void deleteOwner(int ownerId) {
		String sql = "DELETE FROM Owner o WHERE o.id = :ownerId";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setParameter("ownerId", ownerId);
		query.executeUpdate();
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
}
