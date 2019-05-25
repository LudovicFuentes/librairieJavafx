package application.model.beans;



public class Auteur {
	private String nom;
	private String prenom;
	private String pays;
	
	
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


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + ", pays=" + pays + "]";
	}
	
	
}
