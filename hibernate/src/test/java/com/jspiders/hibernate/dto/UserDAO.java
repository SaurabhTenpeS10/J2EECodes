package com.jspiders.hibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDAO {
	private static  EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		UserDTO userDTO = new UserDTO(3, "saurabh", "saurabh@gmail.com",8390488747L,"saurabh@1234");
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
	}
	
	private static void closeConnection( ) {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null ) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
