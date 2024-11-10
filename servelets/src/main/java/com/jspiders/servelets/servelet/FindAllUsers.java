package com.jspiders.servelets.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.servelets.entity.User;
import com.jspiders.servelets.userdb.DataAccess;



@WebServlet("/users")
public class FindAllUsers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccess access = new DataAccess();
		List<User> users = access.findAllUsers();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<b> Users : </b>" + "<br>");
		for (User user : users) {
			printWriter.println(user + "<br>");
		}
	}

}