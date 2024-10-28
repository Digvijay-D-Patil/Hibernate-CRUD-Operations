package com.hibernate.oneToOneRelationship;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmpDetails {

	// Attributes

	@Id
	private int id;

	private String name;

	@OneToOne
	private EmpAddress address;

	// Constructors

	public EmpDetails() {
		super();
	}

	public EmpDetails(int id, String name, EmpAddress address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public EmpAddress getAddress() {
		return address;
	}

	public void setAddress(EmpAddress address) {
		this.address = address;
	}

	// toString method

	@Override
	public String toString() {
		return "Employee id is: " + id + ", name is: " + name + " and address is: " + address.getAddress();
	}

}
