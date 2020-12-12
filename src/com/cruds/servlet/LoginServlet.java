 package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.db.UserDAO;
import com.cruds.demo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		UserDAO dao=new UserDAO();
		User u=new User(username, password);
		
		HttpSession session=request.getSession(true);
		if(dao.User(u))
		{

			/* PrintWriter out= response.getWriter();
			 out.println("LOGIN Sucess" );
			 */
			//request.setAttribute("MESSAGE", "valid Login");
			
			
		

			User role=dao.getrole(username);
			

			session.setAttribute("MESSAGE","hi\t"+username+"\t:)" + role);


			RequestDispatcher rdq=request.getRequestDispatcher("Success.jsp");
			rdq.forward(request, response);


		}
		else
		{
			request.setAttribute("MESSAGE", "Invalid Login");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}



	}

}
