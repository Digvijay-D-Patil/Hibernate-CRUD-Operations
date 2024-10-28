package com.hibernate.manyToManyRelationship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainClass {

	public static void insertData(Session session) {

		Transaction transaction = session.beginTransaction();

		Address ad1 = new Address();
		ad1.setAddressName("Shirol");

		Address ad2 = new Address();
		ad2.setAddressName("Pune");

		Employee e1 = new Employee();
		e1.setName("Purva");

		Employee e2 = new Employee();
		e2.setName("Bhakti");

		List<Address> addressesList1 = new ArrayList<>();
		addressesList1.add(ad1);
		addressesList1.add(ad2);

		List<Employee> employeesList1 = new ArrayList<>();
		employeesList1.add(e1);
		employeesList1.add(e2);

		e1.setAddresses(addressesList1);
		ad1.setEmployees(employeesList1);

		session.save(e1);
		session.save(e2);
		session.save(ad1);
		session.save(ad2);

		transaction.commit();

		System.out.println("Data inserted successfully!");

		session.close();
	}

	public static void displayData(Session session) {

		Employee employee = session.get(Employee.class, 1);

		System.out.println(employee.getId());
		System.out.println(employee.getName());
		employee.getAddresses().forEach(e -> System.out.println(e.getAddressName()));

		session.close();

	}

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

//		insertData(session);
		displayData(session);

		factory.close();

	}

}
