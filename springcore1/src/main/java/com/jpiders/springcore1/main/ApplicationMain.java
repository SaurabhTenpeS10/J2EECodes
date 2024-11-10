package com.jpiders.springcore1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jpiders.springcore1.config.*;
import com.jspiders.springcore1.bean.Application;
public class ApplicationMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig2.class);
		Application bean = applicationContext.getBean(Application.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext)applicationContext).close();
		
	}
}
