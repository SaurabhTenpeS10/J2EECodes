package com.jspiders.usermodule.dao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;

import com.jspiders.usermodule.dto.Admin;
import com.jspiders.usermodule.dto.User;

public class UserDAOImplements implements UserDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;

	@Override
	public void addUser(Scanner scanner) {
		openConnection();

		System.out.println("===========================================================");
		scanner.nextLine();
		System.out.println("Let's Create an Account");
		System.out.println("Enter Your Email: ");
		String email = scanner.nextLine();
		System.out.println("Enter Your Mobile: ");
		long mobile;
		try {
			mobile = scanner.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception Please Enter Your Mobile Number Again");
			mobile = scanner.nextLong();
		}
		scanner.nextLine();
		System.out.println("Enter Your Password: ");
		String password = scanner.nextLine();

		String role = null;
		boolean flag = true;
		while (flag) {
			System.out.println("Select Your Role: \nEnter 1 for User \nEnter 2 for Admin \nEnter 3 for Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				role = "User";
				User user = new User();
				user.setEmail(email);
				user.setMobile(mobile);
				user.setPassword(password);
				user.setRole(role);

				entityTransaction.begin();
				try {
					entityManager.persist(user);
					entityTransaction.commit();
					System.out.println("User registered successfully!");
				} catch (PersistenceException e) {
					entityTransaction.rollback();

					if (e.getCause() instanceof ConstraintViolationException) {
						ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
						String constraintName = cve.getConstraintName();

						if (constraintName != null) {
							if (constraintName.contains("UK_6dotkott2kjsp8vw4d0m25fb7")) { // Assuming this is the
																							// constraint name for email
								System.out.println("Email already exists. Please enter a different email.");
							} else if (constraintName.contains("UK_63cf888pmqtt5tipcne79xsbm")) { // Assuming this is
																									// the constraint
																									// name for mobile
								System.out.println(
										"Mobile number already exists. Please enter a different mobile number.");
							} else {
								System.err.println("A database error occurred: " + cve.getMessage());
							}
						} else {
							System.err.println("A database error occurred: " + cve.getMessage());
						}
					} else {
						System.err.println("An unexpected error occurred: " + e.getMessage());
					}
				} 
				flag = false;
				break;
			case 2:
				openConnection();
				query = entityManager.createQuery("SELECT admin FROM Admin admin WHERE admin.role = ?1");
				query.setParameter(1, "Admin");

				try {
					Admin user1 = (Admin) query.getSingleResult();

					System.err.println("Admin is already Present");
					System.out.println("Enter Your Role as User or Exit");
					break;

				} catch (NoResultException e) {
					Admin admin = new Admin();
					role = "Admin";

					admin.setEmail(email);
					admin.setMobile(mobile);
					admin.setPassword(password);
					admin.setRole(role);

					entityTransaction.begin();
					entityManager.persist(admin);
					entityTransaction.commit();

					flag = false;
					break;
				}

			case 3:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice! Please Choose Your Role Again...");

			}
		}

		
	}

	@Override
	public void deleteUser(long id) {
		openConnection();

		User user = entityManager.find(User.class, id);

		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();

		
	}

	private void deleteAdmin(long id) {
		openConnection();

	Admin admin = entityManager.find(Admin.class, id);

		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();

		
		
	}
	
	@Override
	public void updateUser(User user, Scanner scanner) {
		System.out.println("===================Update Your Profile Information======================");
		boolean flag = true;
		String email;
		long mobile;
		String password;
		while (flag) {
			System.out.println(
					"Enter 1 to Update Your Email \nEnter 2 to Update Your Mobile \nEnter 3 to Update Your Password \n"
							+ "Enter 4 Update Done Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter New Email: ");
				scanner.nextLine();
				email = scanner.nextLine();
				user.setEmail(email);
				break;
			case 2:
				System.out.println("Enter New Mobile: ");
				scanner.nextLine();
				mobile = scanner.nextLong();
				user.setMobile(mobile);
				break;
			case 3:
				System.out.println("Enter New Password: ");
				scanner.nextLine();
				password = scanner.nextLine();
				user.setPassword(password);
				break;
			case 4:
				flag = false;
				System.out.println("Update Done!");
				break;
			default:
				System.out.println("Invalid Input... Please Give Input Again");

			}

		}
		openConnection();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		
	}
	
	
	private void updateAdmin(Admin admin, Scanner scanner) {
		System.out.println("===================Update Your Profile Information======================");
		boolean flag = true;
		String email;
		long mobile;
		String password;
		while (flag) {
			System.out.println(
					"Enter 1 to Update Your Email \nEnter 2 to Update Your Mobile \nEnter 3 to Update Your Password \n"
							+ "Enter 4 Update Done Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter New Email: ");
				scanner.nextLine();
				email = scanner.nextLine();
				admin.setEmail(email);
				break;
			case 2:
				System.out.println("Enter New Mobile: ");
				scanner.nextLine();
				mobile = scanner.nextLong();
				admin.setMobile(mobile);
				break;
			case 3:
				System.out.println("Enter New Password: ");
				scanner.nextLine();
				password = scanner.nextLine();
				admin.setPassword(password);
				break;
			case 4:
				flag = false;
				System.out.println("Update Done!");
				break;
			default:
				System.out.println("Invalid Input... Please Give Input Again");

			}

		}
		openConnection();
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
	
		
	}
	
	@Override
	public User findUserById(long id) {
		openConnection();
		System.out.println("========================== Profile Details ========================");
		User user = entityManager.find(User.class, id);
		System.out.println(user);
		return user;
	}
	private void findAdminById(long id) {
		openConnection();
		Admin admin = entityManager.find(Admin.class, id);
		System.out.println("========================== Profile Details ========================");
		System.out.println(admin);
	}
	@Override
	public User findUserByMobile(long mobile) {
	    openConnection();
	    User user = null;  // Initialize as null
	    query = entityManager.createQuery("SELECT user FROM User user WHERE user.mobile = :mobile");
	    query.setParameter("mobile", mobile);

	    try {
	        user = (User) query.getSingleResult();
	        System.out.println("=================== User Details ======================");
	        System.out.println(user);
	    } catch (NoResultException e) {
	        System.err.println("User not found for mobile: " + mobile);
	    } 

	    return user;
	}
	@Override
	public User findUserByEmail(String email) {
		openConnection();
		User user = new User();
		query = entityManager.createQuery("SELECT user FROM User user WHERE user.email = ?1");
		query.setParameter(1, email);

		try {

			user = (User) query.getSingleResult();
			System.out.println("=================== User Details ======================");
			System.out.println(user);
		} catch (NoResultException e) {
			System.err.println("Invalid email...");

		}

		return user;
	}
	@Override
	public User findUserByEmailAndPassword(String email, String password, Scanner scanner) {
		openConnection();
		User user = new User();
		query = entityManager.createQuery("SELECT user FROM User user WHERE user.email = ?1 AND user.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {

			user = (User) query.getSingleResult();
			System.out.println("========================== Login Successfull ========================");
			userOperations(user, scanner);
		} catch (NoResultException e) {
			System.err.println("Invalid email or password");
		
		} 

		return user;
	}

	@Override
	public Admin findAdminByEmailAndPassword(String email, String password, Scanner scanner) {
		openConnection();
		Admin admin = new Admin();
		query = entityManager
				.createQuery("SELECT admin FROM Admin admin WHERE admin.email = ?1 AND admin.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {
			admin = (Admin) query.getSingleResult();
			System.out.println("========================== Login Successfull ========================");
			adminOperations(admin, scanner);
		} catch (NoResultException e) {
			System.err.println("Invalid email or password");

		} 

		return admin;
	}

	@Override
	public User findUserByMobileAndPassword(long mobile, String password, Scanner scanner) {
		openConnection();
		User user = new User();
		query = entityManager.createQuery("SELECT user FROM User user WHERE user.mobile = ?1 AND user.password = ?2");
		query.setParameter(1, mobile);
		query.setParameter(2, password);

		try {
			user = (User) query.getSingleResult();
			System.out.println("========================== Login Successfull ========================");
			userOperations(user, scanner);
		} catch (NoResultException e) {
			System.err.println("Invalid mobile or password");

		} 
		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		openConnection();
		System.out.println("========================= All Users ==========================");
		query = entityManager.createQuery("SELECT user FROM User user");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) query.getResultList();
		for (User user : users) {
			System.out.println(user);
		}
		return users;
	}

	private void userOperations(User user, Scanner scanner) {
		boolean flag = true;
		int count = 0;
		while (flag) {
			if (count == 1) {
				System.out.println("==================================================================");
			}
			System.out.println("Enter 1 to Check Profile Details \nEnter 2 to Update Profile \nEnter 3 to Delete Account"
							+ "\nEnter 4 For Logout");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				findUserById(user.getId());
				count = 1;
				break;
			case 2:
				updateUser(user, scanner);
				count = 1;
				break;
			case 3:
				deleteUser(user.getId());
				count = 1;
				flag=false;
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("Invalid Input...");
			}
		}
	}

	private void adminOperations(Admin admin, Scanner scanner) {

		System.out.println(
				"Enter 1 to Perform Operation on User \nEnter 2 to Perform Operation on Admin \nEnter 3 to Exit");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			boolean flag = true;
			int count = 0;
			while (flag) {
				if (count == 1) {
					System.out.println("==============================================================");
				}
				System.out.println(
						"Enter 1 to Show All Users Accounts \nEnter 2 to Get User Using Id or Email or Mobile \nEnter 3 to Update User Account"
						+ " \nEnter 4 to Delete User Account" + "\nEnter 5 For Exit");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					findAllUsers();
					count = 1;
					break;
				case 2: 
					System.out.println("Enter 1 for Get User By Id \nEnter 2 for Get User By Email ");
					int sel = scanner.nextInt();
					switch(sel) {
					case 1: 
						System.out.println("Enter User Id to Find User: ");
						int id = scanner.nextInt();
						findUserById(id);
						break;
					case 2: 
						System.out.println("Enter User Email to Find User: ");
						scanner.nextLine();
						String email = scanner.nextLine();
						findUserByEmail(email);
						break;
					
					default: System.out.println("Invalid Input!");
					}
					break;
				case 3:
					findAllUsers();
					System.out.println("Enter User Id to Update User Detail: ");
					long id = scanner.nextLong();
					openConnection();
					User user = entityManager.find(User.class, id);
					updateUser(user, scanner);
					count = 1;
					break;
				case 4:
					System.err.println("Enter User Id to Delete User Account: ");
					long dId = scanner.nextLong();
					deleteUser(dId);
					count = 1;
					break;
				case 5:
					flag = false;
					break;
				default:
					System.out.println("Invalid Input...");
				}
			}
			break;
		case 2: 
			boolean adminFlag = true;
			int count1 = 0;
			while (adminFlag) {
				if (count1 == 1) {
					System.out.println("==============================================================");
				}
				System.out.println("Enter 1 to Check Profile Details \nEnter 2 to Update Profile \nEnter 3 to Delete Account"
								+ "\nEnter 4 For Logout");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					findAdminById(admin.getId());
					count1 = 1;
					break;
				case 2:
					updateAdmin(admin, scanner);
					count1 = 1;
					break;
				case 3:
					deleteAdmin(admin.getId());
					count1 = 1;
					adminFlag=false;
					break;
				case 4:
					adminFlag = false;
					break;
				
				default:
					System.err.println("Invalid Input...");
				}
			}
		}
	}

	

	

	

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("users");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

}