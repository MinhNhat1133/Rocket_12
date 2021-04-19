package com.vti.entity;


public class TypeQuestion {
	private int typeID;
	private String typeName;
	
	public int getId(){
		return typeID;
	}
	public void setId(int id){
		this.typeID =id;
	}
	public String getName(){
		return typeName;
	}
	public void setId(String name){
		this.typeName =name;
	}
}
