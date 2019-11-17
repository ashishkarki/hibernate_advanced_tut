package com.karki.ashish.hibernate_test_project;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.karki.ashish.hibernate_test_project.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {

	private static SessionFactory sessionFactory = null;

	static {
		try {
			loadSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadSessionFactory() {
		var configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("Employee.hbm.xml");

		var serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() throws HibernateException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return session;
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = getSession();
			transaction = session.beginTransaction();

			var employee1 = new Employee("John Doe", 100);
			session.save(employee1);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
