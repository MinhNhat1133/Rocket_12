package com.vti.entity;


public class ExamQuestion {
	private Exam[] exams;
	private Question[] questions;
	
	 public Exam[] getExamOfQuestion() {
	        return exams;
	    }

	    public void setExamOfQuestion(Exam[] exams) {
	        this.exams = exams;
	    }
	    public Question[] getQuestionOfExam() {
	        return questions;
	    }

	    public void setQuestionOfExam(Question[] questions) {
	        this.questions = questions;
	    }
}
