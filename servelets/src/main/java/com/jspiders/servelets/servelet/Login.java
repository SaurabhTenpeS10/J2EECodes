package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servelets.userdb.DataAccess;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		DataAccess dataAccess = new DataAccess();
		boolean status = dataAccess.login(username, password);
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		if(status) {
			printWriter.println("<h1>Login Successful..</h1>");
		} else {
			printWriter.println("<h1>Invalid User or Password</h1>");
		}


	/* @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password); */
		
	}

}
