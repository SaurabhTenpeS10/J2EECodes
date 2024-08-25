package com.jspiders.hibernate.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Company;
import com.jspiders.hibernate.dto.Employee;

public class CompanyDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Company company = new Company();
		company.setName("Infosys");
		company.setLocation("Pune");
		
		Employee employee1 = new Employee();
		employee1.setName("Saurabh");
		employee1.setEmail("saurabh@gmail.com");
		employee1.setMobile(9874561234L);
		
		Employee employee2 = new Employee();
		employee2.setName("Ramesh");
		employee2.setEmail("ramesh@gmail.com");
		employee2.setMobile(9874561230L);
		
		company.setEmployee(Arrays.asList(employee1, employee2));
		
		openConnection();
		
		/*entityTransaction.begin();
		entityManager.persist(employee1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(employee2);
		entityTransaction.commit(); */
//		No Need to Persist Employee Because We Use cascade = CascadeType.PERSIST(or We can use cascade = CascadeType.ALL)
//		cascade = CascadeType.ALL is use to perform all insert, set, remove
		
		
		entityTransaction.begin();
		entityManager.persist(company);
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
