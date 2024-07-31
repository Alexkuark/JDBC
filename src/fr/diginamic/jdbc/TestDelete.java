package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws SQLException {
	
		Connection connection = MaConnection.maConnection();
		Statement statement = connection.createStatement();
		int nb = statement.executeUpdate("DELETE FROM jdbc.fournisseur WHERE nom='La Maison des Peintures'");
		System.out.println(nb);
		statement.close();
		connection.close();
	}

}
