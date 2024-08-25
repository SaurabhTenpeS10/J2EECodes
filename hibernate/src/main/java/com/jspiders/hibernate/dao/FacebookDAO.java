package com.jspiders.hibernate.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.FaceBookUser;
import com.jspiders.hibernate.dto.Post;

public class FacebookDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		FaceBookUser faceBookUser = new FaceBookUser();
		faceBookUser.setName("Ramesh");
		faceBookUser.setPassword("Ramesh@123");
		faceBookUser.setPosts(new ArrayList<Post>());
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(faceBookUser);
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
