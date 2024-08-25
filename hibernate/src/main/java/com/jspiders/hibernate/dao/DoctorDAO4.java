package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.DoctorDTO;
import com.jspiders.hibernate.dto.PatientDTO;

public class DoctorDAO4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		DoctorDTO doctor1=new DoctorDTO();
		doctor1.setName("Ramesh");
		doctor1.setSpeciality("Psychologist");
		
		DoctorDTO doctor2 = new DoctorDTO();
		doctor2.setName("Suresh");
		doctor2.setSpeciality("Cardiologist");
		
		PatientDTO patient1 = new PatientDTO();
		patient1.setName("Umesh");
		patient1.setDoctorDTOs(Arrays.asList(doctor1, doctor2));
		PatientDTO patient2 = new PatientDTO();
		patient2.setName("rakesh");
		patient2.setDoctorDTOs(Arrays.asList(doctor1, doctor2));
		
		doctor1.setPatientDTOs(Arrays.asList(patient1, patient2));
		doctor2.setPatientDTOs(Arrays.asList(patient1, patient2));
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(patient1);
		entityManager.persist(patient2);
		entityManager.persist(doctor1);
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
