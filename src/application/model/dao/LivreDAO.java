
package application.model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import application.model.beans.Livre;

public class LivreDAO extends DAO<Livre> {

	//Premiere méthode find. Renvoie un auteur connaissant son identifiant.
			@Override
			public Livre find(long id) {
				//pouvoir créer un objet auteur à partir d'un enregistrement en base
				
				//Je commence par créer un objet auteur:
				Livre liv = new Livre();

				try {
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from livre where id="+id);
					while (rs.next()) {
						int bd_id = rs.getInt("id");
						String bd_titre = rs.getString("titre");
						String bd_editeur = rs.getString("fk_edi_id");
						Date bd_date = rs.getDate("date");
						String bd_type = rs.getString("type");
						String bd_resume = rs.getString("resume");
						
						liv.setId(bd_id);
						liv.setTitre(bd_titre);
						liv.setEditeur(bd_editeur);
						liv.setDate(bd_date);
						liv.setType(bd_type);
						liv.setResume(bd_resume);
					}
					return liv;
				}
				catch (Exception e) {
					System.out.println("LivreDAO: find() failed: "+e.getLocalizedMessage());
				}
				
				return null;
			}
			
//			//deuxième méthode find. Renvoie la liste des Etudiant portant le nom name.
//			public ArrayList<Auteur> findByName(String name){
//				ArrayList<Auteur> listAut = new ArrayList<Auteur>();
//				
//				try {
//					Statement stmt = connect.createStatement();
//					ResultSet rs = stmt.executeQuery("Select * from auteur where Nom='"+name+"'");
//					while (rs.next()) {
//						
//						Auteur aut = new Auteur();
//						int bd_id = rs.getInt("id");
//						String bd_nom = rs.getString("Nom");
//						String bd_prenom = rs.getString("prenom");
//						Date bd_date = rs.getDate("date");
//						String bd_Pays = rs.getString("pays");
//						
//						aut.setId(bd_id);
//						aut.setNom(bd_nom);
//						aut.setPrenom(bd_prenom);
//						aut.setDate(bd_date);
//						aut.setPays(bd_Pays);	
//						
//						listAut.add(aut);
//					}
//					
//					return listAut;
//				}
//				catch (Exception e) {
//					System.out.println("AuteurDAO: find() failed: "+e.getLocalizedMessage());
//				}
//				
//				return null;
//				
//			}

			@Override
			public Livre create(Livre obj) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Livre update(Livre obj) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void delete(Livre obj) {
				// TODO Auto-generated method stub
				
			}

		}
