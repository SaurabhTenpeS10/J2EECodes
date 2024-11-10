package com.jpiders.springcore1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore1.bean.Software;

public class SoftwareMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.springcore1");
		Software bean = applicationContext.getBean(Software.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
