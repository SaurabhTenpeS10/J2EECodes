package com.jspiders.hibernate.dao;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Doctor;
import com.jspiders.hibernate.dto.Patient;

public class DoctorDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Patient patient1 = new Patient();
		patient1.setName("Ramesh");
		
		Patient patient2 = new Patient();
		patient2.setName("Suresh");
		
		Doctor doctor1 = new Doctor();
		doctor1.setName("Umesh");
		doctor1.setSpeciality("Cardiologist");
		
		Doctor doctor2 = new Doctor();
		doctor2.setName("Mahesh");
		doctor2.setSpeciality("Neurologist");
		
		doctor1.setPatients(Arrays.asList(patient1, patient2));
		doctor2.setPatients(Arrays.asList(patient1, patient2));
		
		openConnection();
		/*entityTransaction.begin();
		entityManager.persist(patient1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(patient2);
		entityTransaction.commit(); No need to Persist Because CascadeType.persist Used*/
		
		entityTransaction.begin();
		entityManager.persist(doctor1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(doctor2);
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
