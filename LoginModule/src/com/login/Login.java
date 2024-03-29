package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    				
    		String username = request.getParameter("uname"); 
    		String password = request.getParameter("pass");
    		LoginDao dao = new LoginDao();

    		if(dao.check(username, password))
    		{
    			HttpSession session = request.getSession();
    			session.setAttribute("uname", username);
    			session.setAttribute("pass", password);
    			
    			response.sendRedirect("welcome.jsp");
    		}
    		else
    		{
    			response.sendRedirect("login.jsp");
    		}
	}

	
}
