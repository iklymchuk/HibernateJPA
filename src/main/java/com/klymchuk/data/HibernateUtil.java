package com.klymchuk.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.klymchuk.data.entities.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			//*for properties only*
			configuration.addAnnotatedClass(User.class);
			return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
					//*should add additional settings for xml configuration*
					.applySettings(configuration.getProperties())
					
							.build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error building the factory");
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
