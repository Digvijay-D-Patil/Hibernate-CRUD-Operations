package com.hibernate.oneToManyRelationship;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EmpDetails {

	@Id
	private int id;

	private String name;

	@OneToMany(mappedBy = "empDetails", cascade = CascadeType.ALL)
	private List<EmpAddress> address;

	public EmpDetails() {
		super();
	}

	public EmpDetails(int id, String name, List<EmpAddress> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

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

	public List<EmpAddress> getAddress() {
		return address;
	}

	public void setAddress(List<EmpAddress> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee Id: " + id + "\nName: " + name + "\nAddress: " + address + "\n-------------";
	}

}
