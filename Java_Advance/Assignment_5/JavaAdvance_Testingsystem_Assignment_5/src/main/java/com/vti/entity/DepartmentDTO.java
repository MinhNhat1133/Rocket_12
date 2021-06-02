package com.vti.entity;

public class DepartmentDTO  {
	private int id;
	private String name;
//	private Address address;
//	
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public DepartmentDTO() {
	}

	public DepartmentDTO(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name  + "]";
	}
	
	

	
}
