package com.scaleupindia.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.repository.PetRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class PetRepositoryImpl implements PetRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public Pet findPet(int petId) {
		String hql = "SELECT p FROM Pet p JOIN FETCH p.owner WHERE p.id = :petId";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Pet.class).setParameter("petId", petId).getSingleResultOrNull();
		}
	}

	@Override
	public List<Pet> findAllPets() {
		String hql = "SELECT p FROM Pet p JOIN FETCH p.owner";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Pet.class).getResultList();
		}
	}

}
