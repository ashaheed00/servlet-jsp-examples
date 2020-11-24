package com.srvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String nameRegex = "^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$";
		final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.*\\W\\w*\\W)(?!.*\\s).{8,}$";
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
		String password = request.getParameter("password");
		if (password.matches(passwordRegex)) {
			request.setAttribute("password", password);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Entered Password is in wrong format. Eg. Pass123*</font>");
			rd.include(request, response);
			out.close();
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
	}

}
