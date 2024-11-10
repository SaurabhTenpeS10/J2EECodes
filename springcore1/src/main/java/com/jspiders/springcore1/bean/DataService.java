package com.jspiders.springcore1.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataService {
	
	//Field Injection: Single Line Initialization
	@Value("This Object provides data service by Field Injection")
	private String serviceInfo;
	
	
	// Constructor Injection
	public DataService(@Value("This Object Provides data service by Constructor Injection") String serviceInfo) {
		super();
		this.serviceInfo = serviceInfo;
	}

	public String getServiceInfo() {
		return serviceInfo;
	}
	
	//Setter Injection
	@Value("This object provides data service by Setter Injection")
	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
	/* If the All Injection is Present then First Priority Goes to Setter Injection*/ 
	@Override
	public String toString() {
		return "DataService [serviceInfo=" + serviceInfo + "]";
	}
	
	
	
}
