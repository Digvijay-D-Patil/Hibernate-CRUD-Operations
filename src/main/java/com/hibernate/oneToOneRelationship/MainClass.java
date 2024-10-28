package com.hibernate.oneToOneRelationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainClass {

	public static void addData(SessionFactory factory) {

		// Employee Address

		EmpAddress ad1 = new EmpAddress();
		ad1.setId(101);
		ad1.setAddress("Kumathe");

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Employee details

		EmpDetails emp1 = new EmpDetails();
		emp1.setId(201);
		emp1.setName("Atharv");
		emp1.setAddress(ad1);

		ad1.setDetails(emp1);

		session.save(emp1);
		session.save(ad1);
		transaction.commit();

		session.close();
		factory.close();
	}

	public static void displayData(SessionFactory factory, int empId) {

		Session session = factory.openSession();

		EmpDetails empData = session.get(EmpDetails.class, empId);
		System.out.println(empData);

//		EmpAddress address1 = session.get(EmpAddress.class, empId);
//		System.out.println(address1);

		session.close();
		factory.close();
	}

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

//		addData(factory);
		displayData(factory, 201);

	}

}
