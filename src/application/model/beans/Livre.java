package application.model.beans;



public class Livre {

	private String titre;
	private String editeur;
	private String auteur;
	private Integer annee;
	private String type;
	
	
	
// Creation d'une methode livre//
	public Livre() {

	}
	

//Generations des Getters et Setters//
	
	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public Integer getAnnee() {
		return annee;
	}


	public void setAnnee(Integer annee) {
		this.annee = annee;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	//Generation de la methode ToString pour que le resultat soit lisible par l'utilisateur//
		@Override
		public String toString() {
			return "Livre [titre=" + titre + ", editeur=" + editeur + ", auteur=" + auteur + ", annee=" + annee + ", type="
					+ type + "]";
		}
