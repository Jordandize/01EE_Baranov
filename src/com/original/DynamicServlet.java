package com.original;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DynamicServlet
 */
@WebServlet("/DynamicServlet")
public class DynamicServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private String userLogin;
	private String userPassword;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicServlet() {
        super();
        // TODO Auto-generated constructor stub
        userLogin = "KMA";
        userPassword = "ta";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println
		(
				"<!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				"<meta charset=\"UTF-8\">" +
				"<title>Login</title>" +
				"</head>" +
				"<body>" +
					"<form method=\"POST\" action=\"DynamicServlet\">" +
						"<div>Login</div><input type=\"text\" name=\"login\"/>" +
						"<div>Password</div><input type=\"password\" name=\"password\"/>" +
						"<div><input type=\"submit\" value=\"Enter\"/></div>" +
					"</form>" +
					"<h5>Login - [KMA], password - [ta].</h5>" +
				"</body>" +
				"</html>"
		);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(login == null || !login.equals(userLogin) || password == null || !password.equals(userPassword)) {
			pw.println
			(
				"<!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				"<meta charset=\"UTF-8\">" +
				"<title>Error</title>" +
				"</head>" +
				"<body>" +
					"<h2>Error! Wrong login or password.</h2>" +
					"<h3><a href=\"DynamicServlet\">Back</a></h3>" +
				"</body>" +
				"</html>"
			);
		} else {
			pw.println
			(
				"<!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				"<meta charset=\"UTF-8\">" +
				"<title>Welcome</title>" +
				"</head>" +
				"<body>" +
					"<h2>Welcome, " + login + "!</h2>" +
				"</body>" +
				"</html>"
			);
		}
		
		pw.close();
	}

}
