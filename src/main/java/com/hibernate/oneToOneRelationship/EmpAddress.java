package com.hibernate.oneToOneRelationship;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmpAddress {

	// Attributes

	@Id
	private int id;

	private String address;

	@OneToOne(mappedBy = "address")
	private EmpDetails details;

	// Constructors

	public EmpAddress() {
		super();
	}

	public EmpAddress(int id, String address, EmpDetails details) {
		super();
		this.id = id;
		this.address = address;
		this.details = details;
	}

	// getter & setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmpDetails getDetails() {
		return details;
	}

	public void setDetails(EmpDetails details) {
		this.details = details;
	}

	// toString method

	@Override
	public String toString() {
		return "Employee id is: " + details.getId() + ", name is: " + details.getName() + " and address is: " + address;
	}

}
