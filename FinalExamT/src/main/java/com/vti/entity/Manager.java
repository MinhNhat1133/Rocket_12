package com.vti.entity;

public class Manager extends User  {
	private int managerID;
	private int exInYear;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Manager(int id, String fullName, String email, String password, int projectID, ProSkill proSkill) {
		super(id, fullName, email, password, projectID, proSkill);
		// TODO Auto-generated constructor stub
	}


	public Manager(int managerID,int exInYear  ) {
		this.managerID = managerID;
		this.exInYear = exInYear;
		// TODO Auto-generated constructor stub
	}

	public Manager(int id,int projectID,String fullName, int expY) {
		super(id,projectID, fullName);
		this.exInYear =expY;
	}




	public Manager(int id, int projectId, String name, String email) {
		// TODO Auto-generated constructor stub
	}


	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getExInYear() {
		return exInYear;
	}

	public void setExInYear(int exInYear) {
		this.exInYear = exInYear;
	}

	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", exInYear=" + exInYear + "]";
	}


}
