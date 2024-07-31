package fr.diginamic.jdbc;

import fr.diginamic.jdbc.MaConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {

	private static final String jdbcUrl = DatabaseConfig.getDbUrl();
	private static final String user = DatabaseConfig.getDbUsername();
	private static final String password = DatabaseConfig.getDbPassword();
	
	public static void main(String[] args) throws SQLException {
	
		Connection connection = MaConnection.maConnection();
		Statement statement = connection.createStatement();
		int nb = statement.executeUpdate("INSERT INTO jdbc.fournisseur (nom) VALUES ('La Maison de la Peinture')");
		System.out.println(nb);
		statement.close();
		connection.close();
	}

}
