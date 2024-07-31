package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestSelect {

	public static void main(String[] args) throws SQLException {

		Connection connection = MaConnection.maConnection();
		Statement statement = connection.createStatement();
		ResultSet curseur = statement.executeQuery("SELECT * FROM jdbc.fournisseur");
		ArrayList<Fournisseur> fournisseurs = new ArrayList<>(); 
		while (curseur.next()) { 
			Integer id = curseur.getInt("ID"); 
			String nom = curseur.getString("NOM"); 
			Fournisseur fournisseurCourant = new Fournisseur(id, nom); 
			fournisseurs.add(fournisseurCourant); 
		}
		for (Fournisseur fournisseurCourant : fournisseurs) {
			System.out.println(fournisseurCourant);
		}
		statement.close();
		connection.close();
	}


}
