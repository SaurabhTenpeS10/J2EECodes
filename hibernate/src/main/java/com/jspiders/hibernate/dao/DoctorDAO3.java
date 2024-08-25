package com.jspiders.hibernate.dao;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Doctor;
import com.jspiders.hibernate.dto.Patient;

public class DoctorDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		
		Doctor doctor = entityManager.find(Doctor.class, 1);
		List<Patient> patients=doctor.getPatients();
		Patient patientToBeDeleted = null;
		for(Patient patient : patients) {
			if(patient.getId()==2) {
				patientToBeDeleted=patient;
				break;
			}
		}
		
		if(patientToBeDeleted != null) {
			patients.remove(patientToBeDeleted);
		}
		
		doctor.setPatients(patients);
		entityTransaction.begin();
		entityManager.persist(doctor);
		entityTransaction.commit();
		
		
		Patient patient = entityManager.find(Patient.class, 2);
		entityTransaction.begin();
		entityManager.remove(patient);
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
