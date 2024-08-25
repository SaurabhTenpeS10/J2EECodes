package com.jspiders.hibernate.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.College;
import com.jspiders.hibernate.dto.Doctor;
import com.jspiders.hibernate.dto.Patient;
import com.jspiders.hibernate.dto.Student;

public class CollegeDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		College college = new College();
		college.setCollegeName("COEP");
		college.setLocation("Pune");
		
		Student student1 = new Student();
		student1.setStudentName("Ramesh");
		student1.setColleges(college);
		
		Student student2 = new Student();
		student2.setStudentName("Suresh");
		student2.setColleges(college);
		
		college.setStudents(Arrays.asList(student1, student2));
		
		openConnection();
	
		entityTransaction.begin();
//		entityManager.persist(student1);
//		entityManager.persist(student2); No Need to Persist CascadeType=ALL is used
		entityManager.persist(college);
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
