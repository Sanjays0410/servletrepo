 package com.cruds.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.db.DepartmentDAO;
import com.cruds.demo.Department;


/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);

		List<Department> list=new DepartmentDAO().getall();

		request.setAttribute("DEPT_LIST", list);


		RequestDispatcher rd=request.getRequestDispatcher("department.jsp");
		rd.forward(request,response);


	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		String action=request.getParameter("ACTION");

		DepartmentDAO dao=new DepartmentDAO();

		if("CREATE".equals(action))
		{

			String id=request.getParameter("deptid");

			String name=request.getParameter("deptname");



			//PrintWriter out= response.getWriter();
			Department s=new Department( Integer.parseInt(id),name);
			if(dao.CreateDept(s))
			{

				request.setAttribute("MESSAGE", "Success");

			}
			else
			{
				//out.println("ERROR");
				request.setAttribute("MESSAGE", "error");
			}
		}

 

		if("DELETE".equals(action))
		{
			String id=request.getParameter("hdnDeptId");
			//System.out.println("DELETE" +id);
			if(dao.delete(id))
			{
				request.setAttribute("MESSAGE", " Deleted Success");

			}
			else
			{
				request.setAttribute("MESSAGE", " Deleted Error");
			}
		}
		if("UPDATE".equals(action))
		{
			String id=request.getParameter("deptid");
			String name=request.getParameter("deptname");
			//System.out.println("UPDATE" +name);
			Department s=new Department(Integer.parseInt(id),name);
			if(dao.update(s))

			{
				request.setAttribute("MESSAGE", " Updated Success");

			}
			else
			{
				request.setAttribute("MESSAGE", " Updated Error");
			} 
		}
		

		
	}
}
