package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServelet1 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter printwriter = res.getWriter();
		printwriter.println("<h1>Hello World! </h1>");
		
		
	}
	
}
