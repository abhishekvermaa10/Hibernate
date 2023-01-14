package com.scaleupindia.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public class HibernateConfiguration {
	private HibernateConfiguration() {

	}

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Owner.class);
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
