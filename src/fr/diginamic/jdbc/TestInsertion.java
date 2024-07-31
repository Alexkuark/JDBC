package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {
	
	public static void main(String[] args) throws SQLException {
	
		Connection connection = MaConnection.maConnection();
		Statement statement = connection.createStatement();
		int nb = statement.executeUpdate("INSERT INTO jdbc.fournisseur (nom) VALUES ('La Maison de la Peinture')");
		System.out.println(nb);
		statement.close();
		connection.close();
	}

}
