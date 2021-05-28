package com.vti.entity;

public class Department {
	private int departmentID;
	private String departmentName;

	//Tao constucter
	public Department() {

	}

	public Department(String departmentName) {
		this.setDepartmentName(departmentName);
		this.setDepartmentID(0);
	}
	public int getId() {
		return getDepartmentID();
	}

	public void setId(int id) {
		this.setDepartmentID(id);
	}

	public String getName() {
		return getDepartmentName();
	}

	public void setName(String name) {
		this.setDepartmentName(name);
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + getDepartmentID() + ", name='" + getDepartmentName() + '\'' + '}';
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}


