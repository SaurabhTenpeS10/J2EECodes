package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServelet2GetParamtr extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		int sum = Integer.parseInt(num1)+ Integer.parseInt(num2);
		
		res.setContentType("text/html");
		PrintWriter printWriter = res.getWriter();
		printWriter.println("<h1> Sum : "+sum+"</h1>");
		

		int mul = Integer.parseInt(num1)* Integer.parseInt(num2);
		
		res.setContentType("text/html");
		printWriter.println("<h1> Multiplication: "+mul+"</h1>");
	}
	
}
