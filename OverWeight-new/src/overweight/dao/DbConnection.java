package overweight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION ="jdbc:mysql://localhost/overweight2";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			//dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/overweight","root","password");
			return dbConnection;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return dbConnection;
	}
}
