package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbcdeletequery 
{
	public static void main(String[] args) 
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String password="SYSTEM";
		String sql="Delete from food where color=?";
		try
		{
			Scanner in=new Scanner(System.in);
			System.out.println("please enter the color of the food");
			String color =in.nextLine();
			
			Class.forName(driver);
			System.out.println("Driver is loaded");
			
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("connection is established");
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,color);
			
			pst.executeUpdate();
			System.out.println("Query is executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
