package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbctranscations1 
{
	public static void main(String[] args) 
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql1="Update UnionBank set balance=? where acc_no=2222";
		String sql2="update UnionBank set balance=? where acc_no=4444";
		try
		{
		int amount=5000;
		Class.forName(driver);
		System.out.println("Driver loaded sucessfully");
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection established sucesfully");
		PreparedStatement pst=con.prepareStatement(sql1);
		pst.setInt(1,(6000+amount));
		pst.executeUpdate();
		pst=con.prepareStatement(sql2);
		pst.setInt(1,(15000-amount));
		pst.executeUpdate();
		System.out.println("Query is excuted sucessfully");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
