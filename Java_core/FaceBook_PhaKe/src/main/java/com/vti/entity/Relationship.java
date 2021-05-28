package com.vti.entity;

import java.util.Date;

public class Relationship {
	private int id;
	private User userID1;
	private User userID2;
	private int status;
	private Date addDate;
	public Relationship() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Relationship(int id, User userID1, User userID2, int status, Date addDate) {
		super();
		this.id = id;
		this.userID1 = userID1;
		this.userID2 = userID2;
		this.status = status;
		this.addDate = addDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserID1() {
		return userID1;
	}
	public void setUserID1(User userID1) {
		this.userID1 = userID1;
	}
	public User getUserID2() {
		return userID2;
	}
	public void setUserID2(User userID2) {
		this.userID2 = userID2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	@Override
	public String toString() {
		return "Relationship [id=" + id + ", userID1=" + userID1 + ", userID2=" + userID2 + ", status=" + status
				+ ", addDate=" + addDate + "]";
	}
	
}
