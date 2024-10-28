package com.hibernate.oneToManyRelationship;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EmpAddress {

	@Id
	private int id;

	private String addressType;

	private String address;

	@ManyToOne
	private EmpDetails empDetails;

	public EmpAddress() {
		super();

	}

	public EmpAddress(int id, String addressType, String address) {
		super();
		this.id = id;
		this.addressType = addressType;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressType() {
		return addressType;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "(" + addressType + " : " + address + ")";
	}

}
