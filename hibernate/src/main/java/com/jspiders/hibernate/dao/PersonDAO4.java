package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.AadharCard;
import com.jspiders.hibernate.dto.BankAccounts;
import com.jspiders.hibernate.dto.Person;

public class PersonDAO4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		Person person = new Person();
		person.setName("Saurabh");
		person.setMobile(839048947L);
		AadharCard aadharCard = new AadharCard();
		aadharCard.setAadharNumber(987456321012L);
		aadharCard.setAddress("Padhegaon");
		BankAccounts account1 = new BankAccounts();
		account1.setAccountNumber(123456789L);
		account1.setBalance(1500000000000000000L);
		BankAccounts account2 = new BankAccounts();
		account2.setAccountNumber(123456987L);
		account2.setBalance(1234569875);
		person.setAadharCard(aadharCard);
		person.setBankAccount(Arrays.asList(account1, account2));
		
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(person);
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
