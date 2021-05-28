package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	private int groupID;
	private String groupName;
	private Account[] accounts;
	private LocalDate createDate;
	private Account creator;

	public Group() {

	}

	public Group(String name, Account creator, Account[] accounts, LocalDate createDate) {
		this.setGroupName(name);
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;

	}

	


	public int getId() {
		return getGroupID();
	}

	public void setId(int id) {
		this.setGroupID(id);
	}

	public String getName() {
		return getGroupName();
	}

	public void setName(String name) {
		this.setGroupName(name);
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group{" + "id=" + getGroupID() + ", name='" + getGroupName() + '\'' + ", creator='" + creator + '\''
				+ ", createDate='" + createDate + ", accounts=" + Arrays.toString(accounts) + '}';
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
