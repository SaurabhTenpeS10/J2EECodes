package com.jspiders.usermodule.dao;

import java.util.List;
import java.util.Scanner;

import com.jspiders.usermodule.dto.Admin;
import com.jspiders.usermodule.dto.User;

public interface UserDAO {

    void addUser(Scanner scanner);

    void deleteUser(long id);

    void updateUser(User user, Scanner scanner);

    User findUserById(long id);

    User findUserByEmailAndPassword(String email, String password, Scanner scanner);
    
    User findUserByMobileAndPassword(long mobile, String password, Scanner scanner);

    Admin findAdminByEmailAndPassword(String email, String password, Scanner scanner);

    List<User> findAllUsers();

    User findUserByEmail(String email);

    User findUserByMobile(long mobile);
}
