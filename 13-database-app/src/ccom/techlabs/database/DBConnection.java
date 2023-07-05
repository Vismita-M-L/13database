package ccom.techlabs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBConnection {
	void connect()
	{
		try
		{   //Registering the drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","vismita2000");
			System.out.println("connection established successfully");
			
			//Get statement
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from student");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("rno")+"\t"+resultSet.getString("name"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
