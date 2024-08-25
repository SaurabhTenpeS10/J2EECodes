package com.jspiders.hibernate.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;


public class UserDAO1 {

	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1);
		userDTO.setName("saurabh");
		userDTO.setEmail("saurabh@gmail.com");
		userDTO.setMobile(8390488974L);
		userDTO.setPassword("saurabh@123");
		
		entityTransaction.begin();
		try {
			entityManager.persist(userDTO);
		} catch (EntityExistsException e) {
			e.printStackTrace();
		}
		entityTransaction.commit();
		
	}
	
}
