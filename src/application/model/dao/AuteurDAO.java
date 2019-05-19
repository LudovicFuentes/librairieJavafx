
package application.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
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
				String query = "INSERT INTO auteur (nom, prenom,pays, dateNaissance, dateDeces) VALUES (?, ?, ?, ?, ?);";
				PreparedStatement preparedStatement = connect.prepareStatement(query);
				preparedStatement.setString(1, obj.getNom());
				preparedStatement.setString(2, obj.getPrenom());
				preparedStatement.setString(3, obj.getPays());
				preparedStatement.setDate(4, obj.getDateNaissance());
				preparedStatement.setDate(5, obj.getDateDeces());
				preparedStatement.execute();
				
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
			// Comme pour la méthode CREATE je me sert de preparedStatement//

			try {
				Statement stmt = connect.createStatement();
					String query = "update auteur set dateDeces= ? where id= ?;";
					PreparedStatement preparedStatement = connect.prepareStatement(query);
					preparedStatement.setDate(1, obj.getDateDeces());
					preparedStatement.setInt(2, obj.getId());
					preparedStatement.execute();
					
			// Je me sert encore une fois de la methode select all pour tout afficher//
				 ResultSet rs = stmt.executeQuery("SELECT * FROM auteur");
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


			try {
				Statement stmt = connect.createStatement();
				stmt.executeQuery("delete from auteur where id="+obj.getId()+";");

					
					
				System.out.println("Auteur supprimé avec succés!!!!");
				}

			
			catch (Exception e) {
				System.out.println("AuteurDAO: delete() failed: "+e.getLocalizedMessage());
			}
			

		}
			
		}

