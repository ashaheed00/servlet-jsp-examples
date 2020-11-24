package com.srvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
@WebServlet(description = "Login Servlet Testing", urlPatterns = "/login", initParams = {
		@WebInitParam(name = "user", value = "aksh007"), @WebInitParam(name = "password", value = "aksh007") })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String nameRegex = "^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$";
		String name = request.getParameter("name");
		if (name.matches(nameRegex)) {
			request.setAttribute("name", name);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Entered Name is in wrong format. Eg. John Smith</font>");
			rd.include(request, response);
			out.close();
		}
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		if (userID.equals(user) && password.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong</font>");
			rd.include(request, response);
			out.close();
		}
	}

}
