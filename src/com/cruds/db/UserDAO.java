package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cruds.demo.*;



public class UserDAO {

	public boolean User(com.cruds.demo.User u)
	{
		String sql="select 1 from user where username=? and password=?";

		boolean found=false;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs!=null && rs.next())
			{
				found=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}
	public User getrole(String username)
	{
		String sql="select role from user where username=?";
		User u=null;
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs!=null && rs.next())
			{
				u=new User(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
