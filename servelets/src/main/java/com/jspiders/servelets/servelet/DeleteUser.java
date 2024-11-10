package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servelets.userdb.DataAccess;

@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		DataAccess dataAccess = new DataAccess();
		int res = dataAccess.deleteUser(email);
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		if(res==1) {
			printWriter.println("<h1>User Delete Successfully</h1>");
		}else {
			printWriter.println("<h1>Something went Wrong...</h1>");
		}
	}
}
