package com.scaleupindia.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.repository.PetRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class PetRepositoryImpl implements PetRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public Double findAverageAgeOfPet() {
		String hql = "SELECT AVG(YEAR(CURRENT_DATE()) - YEAR(p.birthDate)) FROM Pet p";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Double.class).getSingleResultOrNull();
		}
	}

}
