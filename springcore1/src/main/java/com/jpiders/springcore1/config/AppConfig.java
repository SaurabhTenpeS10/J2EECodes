package com.jpiders.springcore1.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages  = "com.jspiders.springcore1")
public class AppConfig {
	
	@Bean  // Indicates that a method produces a bean to be managed by the Spring container. 
	@Scope("singleton")
	public ArrayList<Object> getList(){
		
		return new ArrayList<Object>();
	}
}
