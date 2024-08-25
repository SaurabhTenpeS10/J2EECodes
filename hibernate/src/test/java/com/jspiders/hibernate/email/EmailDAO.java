package com.jspiders.hibernate.email;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class EmailDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
	
		UsersEmail usersEmail = new UsersEmail(1, "ravi@gmail.com", "saurabh@gmail.com", "Meeting Notificatio");
		openConnection();
		entityTransaction.begin();
		entityManager.persist(usersEmail);
		entityTransaction.commit();
		
	
		if (usersEmail!= null) {
			entityTransaction.begin();
			entityManager.remove(usersEmail);
			entityTransaction.commit();
			
		}else {
			System.out.println("Invalid user_id");
			
		}
		
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
			if(entityTransaction.isActive())
			{
				entityTransaction.rollback();
			}
		}
	}
}
