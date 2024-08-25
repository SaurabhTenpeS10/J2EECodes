package com.jspiders.usermodule;

import java.util.Scanner;

import com.jspiders.usermodule.dao.UserDAO;
import com.jspiders.usermodule.dao.UserDAOImplements;

public class App {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImplements();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("==============================Welcome==============================");
            System.out.println("Enter 1 to Sign Up" + "\nEnter 2 to Login as User" + "\nEnter 3 to Login as Admin" + "\nEnter 4 to exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userDAO.addUser(scanner);
                    break;

                case 2:
                    boolean flag = true;
                    while (flag) {
                        System.out.println("============================================================");
                        System.out.println("Enter 1 to Login Using Email \nEnter 2 to Login Using Mobile");
                        int choose = scanner.nextInt();
                        switch (choose) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Enter your Email:");
                                String userEmail = scanner.nextLine();
                                System.out.println("Enter Password:");
                                String userPassword = scanner.nextLine();
                                flag = false;
                                userDAO.findUserByEmailAndPassword(userEmail, userPassword, scanner);
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("Enter your Mobile:");
                                long mobile = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println("Enter Password:");
                                String mPassword = scanner.nextLine();
                                flag = false;
                                userDAO.findUserByMobileAndPassword(mobile, mPassword, scanner);
                                break;
                            default:
                                System.out.println("Invalid Input...");
                        }
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter your Email:");
                    String adminEmail = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String adminPassword = scanner.nextLine();
                    userDAO.findAdminByEmailAndPassword(adminEmail, adminPassword, scanner);
                    break;
                case 4:
                    System.out.println("===========================See you again============================");
                    isRunning = false;
                    UserDAOImplements.closeConnection();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
