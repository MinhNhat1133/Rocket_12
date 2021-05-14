package com.vti.entity;

public class Manager extends User {
	private int exInYear;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String fullName, String email, String password) {
		super(id, fullName, email, password);
		// TODO Auto-generated constructor stub
	}

	public Manager(int exInYear) {
		super();
		this.exInYear = exInYear;
	}

	public int getExInYear() {
		return exInYear;
	}

	public void setExInYear(int exInYear) {
		this.exInYear = exInYear;
	}

	@Override
	public String toString() {
		return "Manager [exInYear=" + exInYear + "]";
	}
	

}
