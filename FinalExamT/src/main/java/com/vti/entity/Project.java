package com.vti.entity;

public class Project {
	private int id;
	private int teamsize;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, int teamsize) {
		super();
		this.id = id;
		this.teamsize = teamsize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", teamsize=" + teamsize + "]";
	}
}
