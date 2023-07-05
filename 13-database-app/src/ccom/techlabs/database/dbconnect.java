package ccom.techlabs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dbconnect {
	private static dbconnect dbconnect;
    private static Connection connection;
	private static Statement statement;
	private ResultSet resultset;

	
	private dbconnect() {
	
	}
    
	public static dbconnect getDbConnection() {
	if(dbconnect==null)
		dbconnect=new dbconnect();
	return dbconnect;
	}

	void connect()
	{
		try
		{   //Registering the drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","vismita2000");
			System.out.println("connection established successfully");
		}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	void execute() {
	try
	{
		//Get statement
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from student");
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt("rno")+"\t"+resultSet.getString("name"));
		}
		resultSet.close();
		statement.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
	void insertStudent() throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Roll Number and Name:");
		 int rno=scanner.nextInt();
		 String name=scanner.next();
		 
		 PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?)");
		  preparedStatement.setInt(1,rno);
		  preparedStatement.setString(2,name);
		  preparedStatement.executeUpdate();
		  System.out.println("Record inserted successfully");
		  
		
	}
	void updateStudent() throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter updated student Roll Number and Name:");
		 int rno=scanner.nextInt();
		 String name=scanner.next();
		 
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE student SET name=? WHERE rno=?");
		 preparedStatement.setString(1,name);
		 preparedStatement.setInt(2,rno);
		 
	      preparedStatement.executeUpdate();
		  System.out.println("Record updated successfully");
		  
		 
	}
	
	void deleteStudent() throws SQLException{
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter deleted  Roll Number and Name:");
			 int rno=scanner.nextInt();
			 String name=scanner.next();
			 
			 PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM student WHERE rno=?");
			  preparedStatement.setInt(1,rno);
			 
			  preparedStatement.executeUpdate();
			  System.out.println("Record deleted successfully");
		}
	}
}
	

	

		
		
