package com.jspiders.hibernate.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Company;
import com.jspiders.hibernate.dto.Employee;

public class CompanyDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		Company company = entityManager.find(Company.class,2);
		List<Employee> employees = company.getEmployee();
		Employee employeeToBeDeleted=null;
		for(Employee employee: employees) {
			if(employee.getId()==3) {
				employeeToBeDeleted=employee;
				break;
			}
		}
		if(employeeToBeDeleted != null) {
			employees.remove(employeeToBeDeleted);
		}
		
		company.setEmployee(employees);
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
		
		Employee employee = entityManager.find(Employee.class, 3);
		entityTransaction.begin();
		entityManager.remove(employee);
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
