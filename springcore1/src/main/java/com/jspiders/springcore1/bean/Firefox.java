package com.jspiders.springcore1.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Firefox")
@Scope("prototype")
@Primary  // When we have multiple implementing Classes then It is use to which Object Should be Injected.
		  // First Priority Goes to @Qualifier than @Primary Annotation.
public class Firefox implements Browser{

	@Override
	public String open() {
		return "Firefox is Running...";
	}

}
