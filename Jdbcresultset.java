package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbcresultset 
{
	public static void main(String[] args)
	{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String driver="oracle.jdbc.driver.OracleDriver";
	String user="system";
	String password="system";
	String sql="Select * from food";
	try
	{
	Class.forName(driver);
	System.out.println("Driver loaded sucessfully");
	
	Connection con=DriverManager.getConnection(url,user,password);
	System.out.println("Connection Established sucessfully");
	
	Statement st=con.createStatement();
	
	ResultSet rs=st.executeQuery(sql);
	while(rs.next()==true)
	{
	System.out.println("Name="+rs.getString(1)+"\nColor="+rs.getString(2)+"\nCost="+rs.getInt(3));
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
