
package application.model.beans;
import java.sql.Date;
import java.util.ArrayList;

public class Auteur {
	private String nom;
	private String prenom;
	private ArrayList<Livre> listeLivre;
	
	public Auteur() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<Livre> getListeLivre() {
		return listeLivre;
	}

	public void setListeLivre(ArrayList<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + "]";
	}










}

