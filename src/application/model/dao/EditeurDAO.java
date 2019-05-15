
package application.model.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import application.model.beans.Editeur;



public class EditeurDAO extends DAO<Editeur> {
	//Premiere méthode find. Renvoie un auteur connaissant son identifiant.
			@Override
			public Editeur find(long id) {
				//pouvoir créer un objet auteur à partir d'un enregistrement en base
				
				//Je commence par créer un objet auteur:
				Editeur edi = new Editeur();

				try {
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from editeur where id="+id);
					while (rs.next()) {
						int bd_id = rs.getInt("id");
						String bd_nom = rs.getString("nom");
						String bd_adress = rs.getString("adress");

						
						edi.setId(bd_id);
						edi.setNom(bd_nom);
						edi.setAdress(bd_adress);
								
					}
					return edi;
				}
				catch (Exception e) {
					System.out.println("EditeurDAO: find() failed: "+e.getLocalizedMessage());
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
			public Editeur create(Editeur obj) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Editeur update(Editeur obj) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void delete(Editeur obj) {
				// TODO Auto-generated method stub
				
			}

		
}
