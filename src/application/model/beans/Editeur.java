
package application.model.beans;
import java.util.ArrayList;



public class Editeur {
	private int id;
	private String nom;
	private String adress;
	private ArrayList<Livre> listeLivres;
	
	public Editeur() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public ArrayList<Livre> getListeLivres() {
		return listeLivres;
	}

	public void setListeLivres(ArrayList<Livre> listeLivres) {
		this.listeLivres = listeLivres;
	}
	public Livre getFromIndex(int index) {
		return listeLivres.get(index);
	}
	
	public void addLivre(Livre l) {
		listeLivres.add(l);
	}
	@Override
	public String toString() {
		return "Editeur [id=" + id + ", nom=" + nom + ", adress=" + adress + "]";
	}

}
