package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.demo.Department;
import com.cruds.demo.Student;

public class StudentDAO {

	
	public boolean Create(Student s)
	{
		String sql="insert into student(usn,name) values(?,?)";
		int rows=0;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getUsn());
			ps.setString(2, s.getName());
			rows=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows>0;
	}
	public List<Student> getall()
	{
		String sql="select usn,name from student";
		List<Student> list=new ArrayList<>();
		Student s=null;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs!=null && rs.next())
				{
					s=new Student(rs.getString(1), rs.getString(2));
					list.add(s);
				}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return list;
	

	}
}
