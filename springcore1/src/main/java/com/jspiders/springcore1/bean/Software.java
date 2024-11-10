package com.jspiders.springcore1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Software {
	@Autowired
	@Qualifier("Firefox")
	private Browser browser;

	
	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	@Override
	public String toString() {
		return "Software [browser= " + browser.open() + "]";
	}
}
