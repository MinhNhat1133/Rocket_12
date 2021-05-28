package com.vti.entity;


import java.time.LocalDate;
import java.util.Date;

public class Exam {
	private int examID;
	private String code;
	private String title;
	private CategoryQuestion[] categoryQuestion;
	private int duration;
	private Account account;
	private LocalDate createDate;
	
	public int getId(){
		return examID;
	}
	public void setId(int id){
		this.examID = id;
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion[] getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion[] categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

  



}
