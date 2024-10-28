package com.hibernate.oneToManyRelationship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainClass {

	public static void insertData(Session session) {

		Transaction transaction = session.beginTransaction();

		EmpAddress address1 = new EmpAddress(101, "Permanant address", "Jaysingpur");
		EmpAddress address2 = new EmpAddress(102, "Office address", "Pune");
		EmpAddress address3 = new EmpAddress(103, "Permanant address", "Delhi");

		List<EmpAddress> addressList1 = new ArrayList<>();
		addressList1.add(address1);
		addressList1.add(address2);

		List<EmpAddress> addressList2 = new ArrayList<>();
		addressList2.add(address3);

		EmpDetails empDetails1 = new EmpDetails(201, "Kartik", addressList1);
		EmpDetails empDetails2 = new EmpDetails(202, "Nawaz", addressList2);

		address1.setEmpDetails(empDetails1);
		address2.setEmpDetails(empDetails1);
		address3.setEmpDetails(empDetails2);

		session.save(empDetails1);
		session.save(empDetails2);

		System.out.println("Inserted Successfully!");

		transaction.commit();
		session.close();

	}

	public static void displayData(Session session) {

		List<EmpDetails> empDetailsList = session.createQuery("From EmpDetails", EmpDetails.class).list();
		empDetailsList.forEach(e -> System.out.println(e));

		session.close();

	}

	public static void deleteEmployee(Session session, int id) {

		Transaction transaction = session.beginTransaction();

		EmpDetails empDetails = session.get(EmpDetails.class, id);

		session.delete(empDetails);
		transaction.commit();

		System.out.println(id + " id deleted successfully!");

		session.close();

	}

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

//		insertData(session);
//		deleteEmployee(session, 202);
		displayData(session);

		factory.close();

	}

}
