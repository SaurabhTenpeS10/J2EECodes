package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "personinfo")

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique = true)
	private long mobile;
	@OneToOne
	private AadharCard aadharCard;
	@OneToMany
	private List<BankAccounts> bankAccount;
}
