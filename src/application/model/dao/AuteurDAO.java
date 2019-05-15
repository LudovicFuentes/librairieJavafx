
package application.model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import application.model.beans.Auteur;





	public class AuteurDAO extends DAO<Auteur> {

		//Premiere méthode find. Renvoie un auteur connaissant son identifiant.
		@Override
		public  Auteur find(long id) {
			//pouvoir créer un objet auteur à partir d'un enregistrement en base
			
			//Je commence par créer un objet auteur:
			Auteur aut = new Auteur();

			try {
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM auteur WHERE id="+id);
				while (rs.next()) {
					int bd_id = rs.getInt("id");
					String bd_nom = rs.getString("nom");
					String bd_prenom = rs.getString("prenom");
					String bd_pays = rs.getString("pays");
					Date bd_dateNaissance = rs.getDate("dateNaissance");
					Date bd_dateDeces = rs.getDate("dateDeces");
					
					aut.setId(bd_id);
					aut.setNom(bd_nom);
					aut.setPrenom(bd_prenom);
					aut.setPays(bd_pays);
					aut.setDateNaissance(bd_dateNaissance);
					aut.setDateDeces(bd_dateDeces);
				}
				return aut;
			}
			catch (Exception e) {
				System.out.println("AuteurDAO: find() failed: "+e.getLocalizedMessage());
			}
			
			return null;
		}
		
//		//deuxième méthode find. Renvoie la liste des Auteur portant le nom "nom".
		public ArrayList<Auteur> findByName(String name){
			ArrayList<Auteur> listAut = new ArrayList<Auteur>();
			
			try {
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM auteur WHERE nom='"+name+"'");
				while (rs.next()) {
					
					Auteur aut = new Auteur();
					int bd_id = rs.getInt("id");
					String bd_nom = rs.getString("nom");
					String bd_prenom = rs.getString("prenom");
					String bd_pays = rs.getString("pays");
					Date bd_dateNaissance = rs.getDate("dateNaissance");
					Date bd_dateDeces = rs.getDate("dateDeces");
					
					aut.setId(bd_id);
					aut.setNom(bd_nom);
					aut.setPrenom(bd_prenom);
					aut.setPays(bd_pays);
					aut.setDateNaissance(bd_dateNaissance);
					aut.setDateDeces(bd_dateDeces);	
					
					listAut.add(aut);
				}
				
				return listAut;
			}
			catch (Exception e) {
				System.out.println("AuteurDAO: find() failed: "+e.getLocalizedMessage());
			}
			
			return null;
			
		}
		

		@Override
		public Auteur create(Auteur obj) {
			try {
				Statement stmt = connect.createStatement();
				
				//Ici on insere le nouvel auteur
				stmt.execute("INSERT INTO auteur VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPays()+"','"+obj.getDateNaissance()+"','"+obj.getDateDeces()+"')");
				
				
				// pour récupérer l'objet que l'on vient d'insérer, cette fois avec l'ID auto-généré
				ResultSet rs = stmt.executeQuery("Select * from auteur");
				
				//Je me place sur la dernière ligne
				rs.last();
				
				//Puis je fais comme avant (comme pour find() et findByName() )
				Auteur aut = new Auteur();
				int bd_id = rs.getInt("id");
				String bd_nom = rs.getString("nom");
				String bd_prenom = rs.getString("prenom");
				String bd_pays = rs.getString("pays");
				Date bd_dateNaissance = rs.getDate("dateNaissance");
				Date bd_dateDeces = rs.getDate("dateDeces");
				
				aut.setId(bd_id);
				aut.setNom(bd_nom);
				aut.setPrenom(bd_prenom);
				aut.setPays(bd_pays);
				aut.setDateNaissance(bd_dateNaissance);
				aut.setDateDeces(bd_dateDeces);
				return aut;
			
			}
			catch (Exception e) {
				System.out.println("AuteurDAO: create() failed: "+e.getLocalizedMessage());
			}
			
			
			return null;
		}

		@Override
		public Auteur update(Auteur obj) {
			Auteur aut = new Auteur();
			

			try {
				Statement stmt = connect.createStatement();
				 stmt.executeQuery("update auteur set nom=" +obj.getNom()+"',prenom='"+obj.getPrenom()+"',pays='"+obj.getPays()+"',dateNaissance='"+obj.getDateNaissance()+"',dateDeces='"+obj.getDateDeces()+
						"'where id='"+obj.getId()+"')");
				 ResultSet rs = stmt.executeQuery("SELECT * FROM auteur WHERE id="+obj.getId());
				while (rs.next()) {
					int bd_id = rs.getInt("id");
					String bd_nom = rs.getString("nom");
					String bd_prenom = rs.getString("prenom");
					String bd_pays = rs.getString("pays");
					Date bd_dateNaissance = rs.getDate("dateNaissance");
					Date bd_dateDeces = rs.getDate("dateDeces");
					
					aut.setId(bd_id);
					aut.setNom(bd_nom);
					aut.setPrenom(bd_prenom);
					aut.setPays(bd_pays);
					aut.setDateNaissance(bd_dateNaissance);
					aut.setDateDeces(bd_dateDeces);	
				}
				return aut;
			}
			catch (Exception e) {
				System.out.println("AuteurDAO: update() failed: "+e.getLocalizedMessage());
			}
			
			return null;
		}

		

		@Override
		public void delete(Auteur obj) {
			Auteur aut = new Auteur();

			try {
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("delete from auteur where id="+obj.getId()+";");
				while (rs.next()) {
					int bd_id = rs.getInt("id");
					String bd_nom = rs.getString("nom");
					String bd_prenom = rs.getString("prenom");
					String bd_pays = rs.getString("pays");
					Date bd_dateNaissance = rs.getDate("dateNaissance");
					Date bd_dateDeces = rs.getDate("dateDeces");
					
					aut.setId(bd_id);
					aut.setNom(bd_nom);
					aut.setPrenom(bd_prenom);
					aut.setPays(bd_pays);
					aut.setDateNaissance(bd_dateNaissance);
					aut.setDateDeces(bd_dateDeces);	
					
					System.out.println("Auteur supprimé avec succés!!!!");
				}

			}
			catch (Exception e) {
				System.out.println("AuteurDAO: delete() failed: "+e.getLocalizedMessage());
			}
			

		}
			
		}

