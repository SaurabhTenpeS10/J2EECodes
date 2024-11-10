package com.jspiders.servelets.servelet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/myservlet")
public class ServveletLifeCycle implements Servlet {

	static {
		System.out.println("Servlet is Loaded");
	}
	{
		System.out.println("Object is Created for the Servelet");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servelet is Destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Servlet is Initialized");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Servlet is Invoke");
	}

}
