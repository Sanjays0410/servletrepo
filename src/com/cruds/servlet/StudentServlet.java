package com.cruds.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.db.DepartmentDAO;
import com.cruds.db.StudentDAO;
import com.cruds.demo.Department;
import com.cruds.demo.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		
		List<Student> list=new StudentDAO().getall();
		request.setAttribute("STUD_LIST", list);


		RequestDispatcher rd=request.getRequestDispatcher("Student.jsp");
		rd.forward(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);


		String usn=request.getParameter("studusn");
		String name=request.getParameter("studname");

		//PrintWriter out= response.getWriter();
		Student s=new Student(usn, name);
		StudentDAO dao=new StudentDAO();
		if(dao.Create(s))
		{
			request.setAttribute("MESSAGE", "Succuss");
		}
		else
		{
			request.setAttribute("MESSAGE", "Error");
		}
		doGet(request, response);

	}

}
