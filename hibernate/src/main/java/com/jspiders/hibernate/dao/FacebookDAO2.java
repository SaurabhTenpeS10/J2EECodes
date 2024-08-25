package com.jspiders.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.FaceBookUser;
import com.jspiders.hibernate.dto.Post;

public class FacebookDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Post post = new Post();
		post.setImage_path("D://photos/img_path.png");
		
		openConnection();
		FaceBookUser user = entityManager.find(FaceBookUser.class, 1);
		post.setUser(user);
		
		List<Post> posts = user.getPosts();
		posts.add(post);
		user.setPosts(posts);
		
		entityTransaction.begin();
		entityManager.persist(post);
		entityManager.persist(user);
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
