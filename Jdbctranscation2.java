package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbctranscation2 
{
	public static void main(String[] args)
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql1="Update UnionBank set balance=? where acc_no=2222";
		String sql2="update UnionBank set balance=? where acc_no=4444";
		Connection con=null;
		try
		{
		int amount=2000;
		Class.forName(driver);
		System.out.println("Driver loaded sucessfully");
		con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection established sucessfully");
		
		con.setAutoCommit(false);
		PreparedStatement pst=con.prepareStatement(sql1);
		pst.setInt(1,(11000-amount));
		pst.executeUpdate();
		pst=con.prepareStatement(sql2);
		pst.setInt(1,(10000+amount));
		pst.executeUpdate();
		
		con.commit();
		}
		catch(Exception e)
		{
			try
			{
			con.rollback();	
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		e.printStackTrace();
		}
	}
}
