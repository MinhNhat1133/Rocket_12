package com.vti.entity;

public class Employee extends User {
	private ProSkill proSkill;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fullName, String email, String password, ProSkill proSkill) {
		super(id, fullName, email, password);
		this.proSkill = proSkill;
		// TODO Auto-generated constructor stub
	}

	public ProSkill getProSkill() {
		return proSkill;
	}

	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [proSkill=" + proSkill + "]";
	}

}
