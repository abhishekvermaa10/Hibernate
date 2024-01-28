package com.scaleupindia.repository.impl;

import java.util.Objects;

import org.hibernate.Hibernate;
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
		try (Session session = sessionFactory.openSession()) {
			return session.get(Pet.class, petId);
		}
	}

	@Override
	public Pet findPetWithOwner(int petId) {
		try (Session session = sessionFactory.openSession()) {
			Pet pet = session.get(Pet.class, petId);
			if (Objects.nonNull(pet)) {
				Hibernate.initialize(pet.getOwner());
			}
			return pet;
		}
	}

}
