package com.jspiders.hibernate.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="accountinfo")
public class BankAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(nullable=false, unique=true)
	private long accountNumber;
	@Column(nullable=false, unique=false)
	private long balance;

	
	
}
