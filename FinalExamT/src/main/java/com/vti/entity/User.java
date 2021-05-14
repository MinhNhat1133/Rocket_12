package com.vti.entity;

public class User {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private int projectID;
	private ProSkill proSkill;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String fullName, String email, String password, int projectID, ProSkill proSkill) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.projectID = projectID;
		this.proSkill = proSkill;
	}

	public User(String fullName2, String email2, String password2) {
		this.fullName = fullName2;
		this.email = email2;
		this.password = password2;
	}

	public User(int UserId, String fullName, String email, int projectID, ProSkill proSkill) {
		this.id = UserId;
		this.fullName = fullName;
		this.email = email;
		this.projectID = projectID;
		this.proSkill = proSkill;
	}

	public User(int id, String fullname, String email ,int projectID) {
		this.id =id;
		this.fullName= fullname;
		this.email =email;
		this.projectID =projectID;
	}

	public User(int int1, String string, String string2) {
		this.id = int1;
		this.fullName=string2;
		this.email = string;
	}

	public User(int id2, String name) {
		this.id =id2;
		this.fullName =name;
	}

	public User(int id2, String name, int projectId1) {
		this.id =id2;
		this.fullName =name;
		this.projectID = projectId1;
	}

	public User(int id2, int projectId2, String name, int teamsize, int expY) {
		this.id = id2;
		this.projectID =projectId2;
		this.fullName = name;
	
	}

	public User(int id2, int projectID2, String fullName2) {
	this.id =id2;
	this.projectID=projectID2;
	this.fullName =fullName2;
	}

	public User(int id2, int projectId2, String name, String email2) {
		this.id=id2;
		this.projectID =projectId2;
		this.fullName =name;
		this.email =email2;
	}

	public User(int id2, String fullName2, String email2, String passWord2) {
		this.id =id2;
		this.fullName =fullName2;
		this.email = email2;
		this.password = passWord2;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public ProSkill getProSkill() {
		return proSkill;
	}

	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", projectID=" + projectID + ", proSkill=" + proSkill + "]";
	}


}
