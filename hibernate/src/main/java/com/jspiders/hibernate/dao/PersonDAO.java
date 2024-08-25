package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.AadharCard;
import com.jspiders.hibernate.dto.Person;

public class PersonDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Person person = new  Person();
		person.setName("Swaroop");
		person.setMobile(8395488787L);
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setAadharNumber(998875445654L);
		aadharCard.setAddress("Wardha");
		
		person.setAadharCard(aadharCard);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		closeTransaction();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	private static void closeTransaction() {
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
