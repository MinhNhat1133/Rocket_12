package com.vti.entity;


public class CategoryQuestion {
	private int categoryID;
	private String categoryName;
	
	public int getId() {
        return categoryID;
    }

    public void setId(int id) {
        this.categoryID = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
