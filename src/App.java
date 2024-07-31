import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.diginamic.jdbc.DatabaseConfig;

public class App {
	
	private static final String jdbcUrl = DatabaseConfig.getDbUrl();
	private static final String user = DatabaseConfig.getDbUsername();
	private static final String password = DatabaseConfig.getDbPassword();
	
	public static void main(String[] args) throws SQLException {
	
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection);
		connection.close();
	}

}
