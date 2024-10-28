package com.hibernate.oneToManyRelationship;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	/*
	 * Hibernate Annotations:
	 * 
	 * @Entity, @Table, @Id, @GeneratedValue, @Column, @Transient, @Temporal, @Lob
	 * 
	 * @OneToOne, @OneToMany, @ManyToOne, @ManyToMany, @JoinColumn
	 * 
	 */

	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {

		if (factory == null) {

			Configuration configuration = new Configuration();
			Properties properties = new Properties();

			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_onetomany_relation");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "root");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, true);

			configuration.setProperties(properties);

			configuration.addAnnotatedClass(EmpDetails.class);
			configuration.addAnnotatedClass(EmpAddress.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			factory = configuration.buildSessionFactory(serviceRegistry);

		}

		return factory;
	}

}
