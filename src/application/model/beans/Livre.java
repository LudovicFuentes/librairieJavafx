
package application.model.beans;

import java.sql.Date;

public class Livre {

	private int id;
	private String titre;
	private String editeur;
	private Date date;
	private String type;
	private String resume;
	
	public Livre() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", editeur=" + editeur + ", date=" + date + ", type=" + type
				+ ", resume=" + resume + "]";
	}
	
}
