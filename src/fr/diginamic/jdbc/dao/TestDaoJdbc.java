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
			//insérer un fournisseur appelé « France de matériaux
			Fournisseur monFournisseur = new Fournisseur(0, "France de matériaux");
			dao.insert(monFournisseur);
			
			//extraire la liste des fournisseurs de la base et les afficher
			afficherListContent(dao.extraire());
			
			
			//modifier le fournisseur appelé « France de matériaux » en « France matériaux »
			String nouveauNomFournisseur = "France matériaux";
			dao.update(monFournisseur.getNom(), nouveauNomFournisseur);
			monFournisseur.setNom(nouveauNomFournisseur);
			
			//extraire la liste des fournisseurs de la base de données et les afficher à nouveau
			afficherListContent(dao.extraire());
			
			//supprimer le fournisseur « France matériaux »
			dao.delete(monFournisseur);
			
			//extraire la liste des fournisseurs de la base de données et les afficher à nouveau
			afficherListContent(dao.extraire());
			
			//Essayez d’insérer en base de données un fournisseur dont le nom contient un simple quote
			monFournisseur.setNom("L’Espace Création");
			dao.insert(monFournisseur);
			afficherListContent(dao.extraire());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
