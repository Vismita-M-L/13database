package ccom.techlabs.database;

import java.sql.SQLException;

public class testDb {

	public static void main(String[] args) throws SQLException {
		dbconnect dbConnection= dbconnect.getDbConnection();
		dbConnection.connect();
		dbConnection.execute();
		
		dbConnection.insertStudent();
		dbConnection.deleteStudent();
		dbConnection.updateStudent();
		

	}

}
