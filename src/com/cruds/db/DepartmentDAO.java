package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.demo.Department;
import com.cruds.demo.Student;


public class DepartmentDAO {

	
	public boolean CreateDept(Department s){

		String sql="insert into department(deptid,deptname) values(?,?)";

		int rows=0;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			rows=ps.executeUpdate();

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return rows>0;	
	}
	
	public List<Department> getall()
	{
		String sql="select deptid,deptname from department";
		List<Department> list=new ArrayList<Department>();
		Department d=null;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs!=null && rs.next())
				{
					d=new Department(rs.getInt(1),rs.getString(2));
					list.add(d);
				}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return list;
		
	}	
	public boolean delete(String deptid)
	{
		String sql="delete from department where deptid=?";
		int rows=0;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(deptid));
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rows>0;
	}
	public boolean update(Department s)
	{
		String sql="update department set deptname=? where deptid=?";
		
		int rows=0;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getId());
			
			rows=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows>0;
	}
}
