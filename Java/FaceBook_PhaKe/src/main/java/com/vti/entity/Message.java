package com.vti.entity;

import java.util.Date;

public class Message {
	private int messageID;
	private User userSeID;
	private User userReID;
	private String content;
	private Date MessageDate;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int messageID, User userSeID, User userReID, String content, Date messageDate) {
		super();
		this.messageID = messageID;
		this.userSeID = userSeID;
		this.userReID = userReID;
		this.content = content;
		MessageDate = messageDate;
	}

	public Message(int messageID, String content, Date messageDate) {
		super();
		this.messageID = messageID;
		this.content = content;
		MessageDate = messageDate;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public User getUserSeID() {
		return userSeID;
	}

	public void setUserSeID(User userSeID) {
		this.userSeID = userSeID;
	}

	public User getUserReID() {
		return userReID;
	}

	public void setUserReID(User userReID) {
		this.userReID = userReID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMessageDate() {
		return MessageDate;
	}

	public void setMessageDate(Date messageDate) {
		MessageDate = messageDate;
	}

	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", userSeID=" + userSeID + ", userReID=" + userReID + ", content="
				+ content + ", MessageDate=" + MessageDate + "]";
	}

	public String toString_IdContentDate() {
		return "messageID: " + messageID + " || " + "content :" + content + " || " + "MessageDate: " + MessageDate;
	}

}
