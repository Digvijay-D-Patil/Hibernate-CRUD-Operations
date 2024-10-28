package com.hibernate.crudDB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainClass {

	// Add data

	public static void addData(SessionFactory factory) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student1 = new Student();
		student1.setName("Rohit");
		student1.setCollegeName("SGU");
		student1.setAddress("Ichalkaranji");
		student1.setEmail("rohit@gmail.com");

		Student student2 = new Student();
		student2.setName("Abhi");
		student2.setCollegeName("Jaysingpur college");
		student2.setAddress("Kolhapur");
		student2.setEmail("abhi@gmail.com");

		transaction.commit();
		session.save(student1);
		session.save(student2);

		System.out.println("Student register successfully!");

		session.close();
		factory.close();
	}

	// Display all data

	public static void displayAllData(SessionFactory factory) {

		Session session = factory.openSession();

		List<Student> studentDataList = session.createQuery("from Student", Student.class).list();

		if (!studentDataList.isEmpty()) {
			studentDataList.forEach(e -> System.out.println(e));
		} else {
			System.out.println("Student list is empty");
		}

		session.close();
		factory.close();
	}

	// Display perticular data

	public static void displayPerticularData(SessionFactory factory, int studentId) {

		Session session = factory.openSession();

		Student s1 = session.get(Student.class, studentId);

		if (s1 != null) {
			System.out.println(s1);
		} else {
			System.out.println("Student not found");
		}

		session.close();
		factory.close();
	}

	// Update data

	public static void updateData(SessionFactory factory, int studentId) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student s1 = session.get(Student.class, studentId);
		s1.setName("Hemant");
		s1.setCollegeName("DKTE");
		s1.setAddress("Shirol");
		s1.setEmail("hemant@gmail.com");

		transaction.commit();
		session.saveOrUpdate(s1);

		System.out.println("Student updated successfully!");

		session.close();
		factory.close();

	}

	// Delete data

	public static void deleteData(SessionFactory factory, int studentId) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student s1 = session.get(Student.class, studentId);

		session.delete(s1);
		transaction.commit();

		System.out.println("Student data deleted successfully");

		session.close();
		factory.close();

	}

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

//		addData(factory);
//		displayAllData(factory);
//		displayPerticularData(factory, 2);
//		updateData(factory, 3);
//		deleteData(factory, 4);

	}

}
