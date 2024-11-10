package com.jspiders.springcore1.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Chrome")
@Scope("prototype")
public class Chrome implements Browser {

	@Override
	public String open() {
		return "Chrome is Running...";
	}

}
