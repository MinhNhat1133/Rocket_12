package com.vti.entity;


public class Answer {
	private int answerID;
	private String content;
	private Question question;
	private boolean isCorrect;
	
	public int getId() {
        return answerID;
    }

    public void setId(int id) {
        this.answerID = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}


