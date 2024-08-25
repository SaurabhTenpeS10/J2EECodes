package com.jspiders.hibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAOJPQL1 {
		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		private static EntityTransaction entityTransaction;
		private static Query query;
		
		public static void main(String[] args) {
			openConnection();
			query=entityManager.createQuery("SELECT user FROM UserDTO user WHERE user.email = ?1 AND user.password = ?2");
			query.setParameter(1, "raman@gmail.com");
			query.setParameter(2, "raman@12334");
			try {
				UserDTO user=(UserDTO) query.getSingleResult();
				System.out.println(user);
			} catch (NoResultException e) {
				System.out.println("Invalid email or password");
				e.printStackTrace();
			}finally {
				closeConnection();
			}
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
