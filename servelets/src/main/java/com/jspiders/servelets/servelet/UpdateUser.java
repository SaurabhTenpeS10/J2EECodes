package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servelets.entity.User;
import com.jspiders.servelets.userdb.DataAccess;

@WebServlet("/update-user")
public class UpdateUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		DataAccess dataAccess = new DataAccess();
		User user = dataAccess.findUserByEmail(email);
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		if(user !=null) {
			req.setAttribute("user", user);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		} else {
			printWriter.println("<h1>Something went Wrong..</h1>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String password = req.getParameter("password");
		
		DataAccess dataAccess = new DataAccess();
		int res = dataAccess.updateUser(username, email, mobile, password);
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		if(res == 1) {
			printWriter.println("<h1>User Update Successfully</h1>");
			req.getRequestDispatcher("users.jsp").include(req, resp);
		} else {
			printWriter.println("<h1>Something went Wrong..</h1>");
			req.getRequestDispatcher("users.jsp").include(req, resp);
		}
	}
}
