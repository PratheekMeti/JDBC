package com.jdbspratice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbcupdatequery 
{
	public static void main(String[] args)
	{
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    String driver="oracle.jdbc.driver.OracleDriver";
    String user="system";
    String password="system";
    String sql="Update food set cost=? where name=?";
    try
    {
    Scanner in=new Scanner(System.in);
 
    System.out.println("Enter the name of the food:");
    String name=in.next();
    System.out.println("Please enter the updated cost:");
    int cost=in.nextInt();
    Class.forName(driver);
    System.out.println("Driver loaded sucessfully");
    
    Connection con=DriverManager.getConnection(url,user,password);
    System.out.println("Connection Established Sucessfully");
    
    PreparedStatement pst=con.prepareStatement(sql);
    pst.setInt(1,cost);
    pst.setString(2,name);
  
    pst.executeUpdate();
    System.out.println("Query Excuted sucessfully");
    
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
	}
}
