package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.ApplicationDTO;
import com.jspiders.hibernate.dto.MobileDTO;

public class ApplicationDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		ApplicationDTO applicationDTO1 = new ApplicationDTO();
		applicationDTO1.setName("System");
		applicationDTO1.setSize(50);
		ApplicationDTO applicationDTO2 = new ApplicationDTO();
		applicationDTO2.setName("LogSystem");
		applicationDTO2.setSize(100);
		MobileDTO mobileDTO1 = new MobileDTO();
		mobileDTO1.setBrand("Poco");
		mobileDTO1.setApk("QTalk");
		MobileDTO mobileDTO2 = new MobileDTO();
		mobileDTO2.setBrand("Poco");
		mobileDTO2.setApk("Camera");
		mobileDTO1.setApplicationDTOs(Arrays.asList(applicationDTO1, applicationDTO2));
		applicationDTO1.setMobileDTOs(Arrays.asList(mobileDTO1, mobileDTO2));
		entityTransaction.begin();
		entityManager.persist(applicationDTO1);
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
