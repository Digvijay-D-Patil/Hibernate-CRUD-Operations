package com.hibernate.crudDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String address;

	@Column(name = "college_name")
	private String collegeName;

	private String email;

	// Constructors

	public Student() {
		super();
	}

	public Student(int id, String name, String address, String collegeName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.collegeName = collegeName;
		this.email = email;
	}

	// getter & setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString method

	@Override
	public String toString() {
		return "Id: " + id + "\nName: " + name + "\nAddress: " + address + "\nCollege name: " + collegeName
				+ "\nEmail: " + email + "\n----------------";
	}

}
