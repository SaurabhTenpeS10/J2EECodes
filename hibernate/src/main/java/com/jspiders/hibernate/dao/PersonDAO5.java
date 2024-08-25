package com.jspiders.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.BankAccounts;
import com.jspiders.hibernate.dto.Person;

public class PersonDAO5 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		openConnection();
		Person person = entityManager.find(Person.class, 1);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		List<BankAccounts> bankAccounts = person.getBankAccount();
		for (BankAccounts bankAccount : bankAccounts) {
			entityTransaction.begin();
			entityManager.remove(bankAccount);
			entityTransaction.commit();
		}
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

}