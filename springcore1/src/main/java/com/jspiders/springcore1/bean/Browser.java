package com.jspiders.springcore1.bean;

import org.springframework.stereotype.Component;

@Component // Here we can use @Component Annotation but no use because object cannot be created for interface. 
		   // This Annotation must use with Implementing Classes
public interface Browser {
	String open();
}
