package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbcuserinput
{
	public static void main(String[] args) 
	{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String driver="oracle.jdbc.driver.OracleDriver";
	String user="system";
	String password="system";
	String sql="Insert into food values(?,?,?)";
	try
	{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the food:");
	String name=in.next();
	System.out.println("Enter the food color:");
	String color=in.next();
	System.out.println("Enter the cost");
	int cost=in.nextInt();
	
	Class.forName(driver);
	System.out.println("Driver loaded sucessfully");
	
	Connection con=DriverManager.getConnection(url,user,password);
	System.out.println("Connection Established Successfully");
	
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,name);
	pst.setString(2,color);
	pst.setInt(3,cost);
	
	pst.executeUpdate();
	System.out.println("Query is excuted sucessfully");
	}
	catch(Exception e)
	{
	e.printStackTrace();	
	}
	}
}
