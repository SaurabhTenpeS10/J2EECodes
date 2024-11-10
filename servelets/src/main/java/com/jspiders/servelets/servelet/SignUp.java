package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servelets.userdb.DataAccess;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String password = req.getParameter("password");
		
		DataAccess dataAccess = new DataAccess();
		int res = dataAccess.addUser(username, email, mobile, password);
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		if(res == 1) {
			printWriter.println("<h1>Sign In SuccessFull..</h1>");
			req.getRequestDispatcher("/login.html").forward(req, resp);

		}
		
	
	}
	
	/* @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(email);
		System.out.println(mobile);
		System.out.println(password);
	
	} */
}
