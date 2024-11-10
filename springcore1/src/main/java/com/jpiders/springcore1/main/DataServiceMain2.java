package com.jpiders.springcore1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpiders.springcore1.config.AppConfig;
import com.jspiders.springcore1.bean.DataService2;

public class DataServiceMain2 {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		DataService2 bean = applicationContext.getBean(DataService2.class);
		System.out.println(bean);
		
		((AnnotationConfigApplicationContext)applicationContext).close();
		
	}
	
}
