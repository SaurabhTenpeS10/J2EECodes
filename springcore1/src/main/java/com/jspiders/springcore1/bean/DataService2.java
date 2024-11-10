package com.jspiders.springcore1.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataService2 {
	
	// Field Injection
	@Value("This object provides data service by Field Injection")
	private String serviceInfo;
	@Autowired
	private ArrayList<Object> arrayList;

	//Constructor Injection
	public DataService2(@Value("This object provides data service by Field Injection") String serviceInfo,@Autowired ArrayList<Object> arrayList) {
		super();
		this.serviceInfo = serviceInfo;
		this.arrayList = arrayList;
	}

	public String getServiceInfo() {
		return serviceInfo;
	}
	
	// Setter Injection
	@Value("This object provides data service by Field Injection")
	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
	public ArrayList<Object> getArrayList() {
		return arrayList;
	}
	@Autowired
	public void setArrayList(ArrayList<Object> arrayList) {
		this.arrayList = arrayList;
	}

	@Override
	public String toString() {
		return "DataService2 [serviceInfo=" + serviceInfo + ", arrayList=" + arrayList + "]";
	}
	
	
	
}
