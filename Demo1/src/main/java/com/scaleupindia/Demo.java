package com.scaleupindia;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.scaleupindia.entity.Owner;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Owner.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		configuration.buildSessionFactory(serviceRegistry);
	}
}
