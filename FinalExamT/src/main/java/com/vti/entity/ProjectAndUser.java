package com.vti.entity;

public class ProjectAndUser extends Project {
	private int projectId;
	private int userID;
	private Role role;
	public ProjectAndUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectAndUser(int id, int teamsize) {
		super(id, teamsize);
		// TODO Auto-generated constructor stub
	}
	public ProjectAndUser(int projectId, int userID, Role role) {
		super();
		this.projectId = projectId;
		this.userID = userID;
		this.role = role;
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ProjectAndUser [projectId=" + projectId + ", userID=" + userID + ", role=" + role + "]";
	}
}
