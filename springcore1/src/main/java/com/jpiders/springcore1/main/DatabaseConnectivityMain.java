package com.jpiders.springcore1.main;

import java.io.Closeable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore1.bean.DatabaseConnection;

public class DatabaseConnectivityMain {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_config.xml");
//		DatabaseConnection bean = applicationContext.getBean(DatabaseConnection.class);
//		System.out.println(bean);
		DatabaseConnection bean1 = (DatabaseConnection)applicationContext.getBean("connection1");
		System.out.println(bean1);
		DatabaseConnection bean2 = (DatabaseConnection) applicationContext.getBean("connection2");
		System.out.println(bean2);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
