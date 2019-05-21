
package application.model.beans;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Livre {

	private StringProperty titre;
	private StringProperty editeur;
	private StringProperty auteur;
	private IntegerProperty annee;
	private StringProperty type;
	
	
	

	public Livre() {
		super();
		this.titre = new SimpleStringProperty();
		this.editeur = new SimpleStringProperty();
		this.auteur = new SimpleStringProperty();
		this.annee = new SimpleIntegerProperty();
		this.type = new SimpleStringProperty();
	}
	


	public String getTitre () {
        return titre.get();
    }
 
    public void setTitre(String Titre){
        this.titre.set(Titre);
    }
 
    public StringProperty TitreProperty() {
        return titre;
    }

	public String getEditeur () {
        return editeur.get();
    }
 
    public void setEditeur(String Editeur){
        this.editeur.set(Editeur);
    }
 
    public StringProperty EditeurProperty() {
        return editeur;
    }
	public String getAuteur() {
        return auteur.get();
    }
 
    public void setAuteur(String Auteur){
        this.auteur.set(Auteur);
    }
 
    public StringProperty AuteurProperty() {
        return auteur;
    }
	public int getAnnee () {
        return annee.get();
    }
 
    public void setAnnee(int Annee){
        this.annee.set(Annee);
    }
 
    public IntegerProperty AnneeProperty() {
        return annee;
    }
	public String getType() {
        return type.get();
    }
 
    public void setType(String Type){
        this.type.set(Type);
    }
 
    public StringProperty TypeProperty() {
        return type;
    }
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", editeur=" + editeur + ", auteur=" + auteur + ", annee=" + annee + ", type="
				+ type + "]";
	}









	



	
}
