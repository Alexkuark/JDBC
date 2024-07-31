package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws SQLException {
	
		Connection connection = MaConnection.maConnection();
		Statement statement = connection.createStatement();
		int nb = statement.executeUpdate("UPDATE jdbc.fournisseur SET nom='La Maison des Peintures' WHERE nom='La Maison de la Peinture'");
		System.out.println(nb);
		statement.close();
		connection.close();
	}

}
