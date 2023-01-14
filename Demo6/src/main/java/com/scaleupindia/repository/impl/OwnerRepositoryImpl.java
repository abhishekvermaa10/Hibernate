package com.scaleupindia.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
}
