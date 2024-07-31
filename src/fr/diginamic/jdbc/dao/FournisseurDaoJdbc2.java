package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.MaConnection;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc2 implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() throws SQLException {
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
		statement.close();
		connection.close();
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		Connection connection = MaConnection.maConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO jdbc.fournisseur (nom) VALUES (?)");
		statement.setString(1, fournisseur.getNom());
		int nb = statement.executeUpdate();
		statement.close();
		connection.close();

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		Connection connection = MaConnection.maConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE jdbc.fournisseur SET nom=? WHERE nom=?");
		statement.setString(1, nouveauNom);
		statement.setString(2, ancienNom);
		int nb = statement.executeUpdate();
		statement.close();
		connection.close();
		return nb;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		Connection connection = MaConnection.maConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM jdbc.fournisseur WHERE nom=?");
		statement.setString(1, fournisseur.getNom());
		int nb = statement.executeUpdate();
		statement.close();
		connection.close();
		return nb > 0;
	}
}
