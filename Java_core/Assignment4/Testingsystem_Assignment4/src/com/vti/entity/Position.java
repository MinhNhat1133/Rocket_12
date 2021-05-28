package com.vti.entity;

public class Position {
	private int positionID;
	private String positionName;

	@Override
	public String toString() {
		return "Position [positionID=" + getPositionID() + ", positionName=" + getPositionName() + "]";
	}

	public int getId() {
		return getPositionID();
	}

	public void setId(int id) {
		this.setPositionID(id);
	}

	public String getName() {
		return getPositionName();
	}

	public void setName(String name) {
		this.setPositionName(name);
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}
