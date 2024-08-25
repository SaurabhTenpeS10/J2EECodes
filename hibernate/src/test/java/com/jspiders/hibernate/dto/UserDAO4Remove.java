package com.jspiders.hibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDAO4Remove {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, 1);
		if (userDTO!= null) {
			entityTransaction.begin();
			entityManager.remove(userDTO);
			entityTransaction.commit();
			
		}else {
			System.out.println("Invalid user_id");
			
		}
		closeConnection();
		
		
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory !=null) {
			entityManagerFactory.close();
			
		}if (entityManager!=null) {
			entityManager.close();
			
		}if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
