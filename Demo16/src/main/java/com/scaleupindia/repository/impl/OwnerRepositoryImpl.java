package com.scaleupindia.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.scaleupindia.config.HibernateConfiguration;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
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
	public void updatePetDetails(int petId, String petName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pet pet = session.get(Pet.class, petId);
		pet.setName(petName);
		session.merge(pet);
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
		query.setCacheable(true);
		List<Owner> ownerList = query.list();
		session.close();
		return ownerList;
	}

	@Override
	public List<Owner> findAllOwnersWithIds(List<Integer> ownerIdList) {
		Session session = sessionFactory.openSession();
		List<Owner> ownerList = ownerIdList.stream().map(ownerId -> session.get(Owner.class, ownerId)).toList();
		session.close();
		return ownerList;
	}	
}
