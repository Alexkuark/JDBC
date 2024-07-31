package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnection {
	
	private static final String jdbcUrl = DatabaseConfig.getDbUrl();
	private static final String user = DatabaseConfig.getDbUsername();
	private static final String password = DatabaseConfig.getDbPassword();
	
	public static Connection maConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, user, password);
	}

}
