package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDaoJdbc {
	
	public static void afficherListContent(List<Fournisseur> fournisseurs) {
		for (Fournisseur fournisseurCourant : fournisseurs) {
			System.out.println(fournisseurCourant);
		}
	}

	public static void main(String[] args) {
		
		FournisseurDaoJdbc2 dao = new FournisseurDaoJdbc2();
		
		try {
			//ins�rer un fournisseur appel� � France de mat�riaux
			Fournisseur monFournisseur = new Fournisseur(0, "France de mat�riaux");
			dao.insert(monFournisseur);
			
			//extraire la liste des fournisseurs de la base et les afficher
			afficherListContent(dao.extraire());
			
			
			//modifier le fournisseur appel� � France de mat�riaux � en � France mat�riaux �
			String nouveauNomFournisseur = "France mat�riaux";
			dao.update(monFournisseur.getNom(), nouveauNomFournisseur);
			monFournisseur.setNom(nouveauNomFournisseur);
			
			//extraire la liste des fournisseurs de la base de donn�es et les afficher � nouveau
			afficherListContent(dao.extraire());
			
			//supprimer le fournisseur � France mat�riaux �
			dao.delete(monFournisseur);
			
			//extraire la liste des fournisseurs de la base de donn�es et les afficher � nouveau
			afficherListContent(dao.extraire());
			
			//Essayez d�ins�rer en base de donn�es un fournisseur dont le nom contient un simple quote
			monFournisseur.setNom("L�Espace Cr�ation");
			dao.insert(monFournisseur);
			afficherListContent(dao.extraire());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
