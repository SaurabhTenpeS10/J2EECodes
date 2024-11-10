package com.jspiders.springcore1.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Application {
	@Value("Youtube")
	private String apkName;
	@Value("101")
	private int apkVersion;
	@Value("12")
	private double apkSize;
	@Autowired
	private ArrayList arrayList;
	
	
	public Application() {
		super();
	}


	


	public Application(String apkName, int apkVersion, double apkSize, ArrayList arrayList) {
		super();
		this.apkName = apkName;
		this.apkVersion = apkVersion;
		this.apkSize = apkSize;
		this.arrayList = arrayList;
	}


	@Override
	public String toString() {
		return "Application [apkName=" + apkName + ", apkVersion=" + apkVersion + ", apkSize=" + apkSize
				+ ", arrayList=" + arrayList + "]";
	}
	
	
}
