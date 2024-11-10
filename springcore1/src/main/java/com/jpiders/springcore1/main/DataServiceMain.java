package com.jpiders.springcore1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore1.bean.DataService;

public class DataServiceMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.springcore1");
		DataService bean = applicationContext.getBean(DataService.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext)applicationContext).close();
		
	}
}
