package com.jspiders.hibernate.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_mail")
public class UsersEmail {
    @Id
	private int id;
    @Column(nullable = false, unique = false)
	private String senderName;
    @Column(nullable = false, unique = false)
	private String receiverName;
    @Column(nullable = false, unique = false)
	private String subject;

	public UsersEmail(int id, String senderName, String receiverName, String subject) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public UsersEmail() {
		super();
	}
	
	
}
