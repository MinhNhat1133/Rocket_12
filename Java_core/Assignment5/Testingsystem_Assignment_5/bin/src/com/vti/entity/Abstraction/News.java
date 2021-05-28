package com.vti.entity.Abstraction;

public class News implements INews {
	private int iD;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int[] rates;

	public int getiD() {
		return iD;
	}

	public void setiD(int id) {
		this.iD = id;
	}

	public String gettitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getpublishDate() {
		return publishDate;
	}

	public void setpublishDate(String publishDate) {
		this.title = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public float getaverageRate() {
		return averageRate;
	}

	public int[] getrate() {
		return rates;
	}

	public void setrate(int[] rates) {
		this.rates = rates;
	}

	@Override
	public void display() {
		System.out.println("//" + "Title: " + title);
		System.out.print("//" + "Publish Date: " + publishDate);
		System.out.print("//" + "Author: " + author);
		System.out.print("//" + "Content: " + content);
		System.out.print("//" + "AverageRate: " + averageRate);
	}

	@Override
	public float caculate() {
		averageRate = (float) (rates[0] + rates[1] + rates[2]) / 3;
		return averageRate;
	}

}
