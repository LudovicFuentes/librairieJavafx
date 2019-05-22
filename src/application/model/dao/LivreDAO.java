package application.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import application.model.beans.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



	public class LivreDAO extends  DAO<Livre> {
		
//Creation d'une methode find de paramétre Object value qui permettra de pouvoir mettre le value clause à plusieur endroit, etant donnée//
//que nous effectuons une recherche sur plusieurs element de la table mais avec 1 seul textfield//
		public  ObservableList <Livre> find(Object value) {
			String valueClause = value.toString();
			//Creation de l'observablelist utile pour pouvoir mettre les informations dans le table view//
			ObservableList <Livre> listliv = FXCollections.observableArrayList();
		
				try {
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("select * from livre where titre= '"+valueClause+"' or  auteur= '"+valueClause+"'or editeur= '"+valueClause+"' or annee='"+valueClause+"'or type='"+valueClause+"';");
					while (rs.next()) {
						//Creation d'un objet livre qui va permettre de recupérer les valeurs de la BDD//
						Livre liv = new Livre();
						String bd_titre = rs.getString("titre");
						String bd_editeur = rs.getString("editeur");
						String bd_auteur = rs.getString("auteur");
						int bd_année = rs.getInt("annee");
						String bd_type = rs.getString("type");

						liv.setTitre(bd_titre);
						liv.setEditeur(bd_editeur);
						liv.setAuteur(bd_auteur);
						liv.setAnnee(bd_année);
						liv.setType(bd_type);

						
						listliv.add(liv);
					}
					
					return listliv;
				}
				catch (Exception e) {
					System.out.println("LivreDAO: find() failed: "+e.getLocalizedMessage());
				}
				
				return null;
				
			}

		
// Creation de la methode findall qui herite de DAO//
			@Override
			public  ObservableList <Livre> findall() {

				ObservableList <Livre> listliv = FXCollections.observableArrayList();
			
					try {
						Statement stmt = connect.createStatement();
						ResultSet rs = stmt.executeQuery("select * from livre") ;
						while (rs.next()) {
							Livre liv = new Livre();
							String bd_titre = rs.getString("titre");
							String bd_editeur = rs.getString("editeur");
							String bd_auteur = rs.getString("auteur");
							int bd_année = rs.getInt("annee");
							String bd_type = rs.getString("type");

							liv.setTitre(bd_titre);
							liv.setEditeur(bd_editeur);
							liv.setAuteur(bd_auteur);
							liv.setAnnee(bd_année);
							liv.setType(bd_type);

							
							listliv.add(liv);
						}
						
						return listliv;
					}
					catch (Exception e) {
						System.out.println("LivreDAO: findall() failed: "+e.getLocalizedMessage());
					}
					
					return null;
					
				}
// Methode pour creer qui herite de DAO//
			@Override
			public ObservableList <Livre> Create (Livre Obj) {

				try {
					
					//Ici on insere le nouveau livre//
					PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO livre(titre,auteur,annee,editeur,type) VALUES ( ?, ?, ?, ?, ?)");
					preparedStatement .setString( 1, Obj.getTitre() );   
					preparedStatement .setString( 2, Obj.getAuteur() );   
					preparedStatement .setInt( 3, Obj.getAnnee() );   
					preparedStatement .setString( 4, Obj.getEditeur() );   
					preparedStatement .setString( 5, Obj.getType() );   
					preparedStatement .executeUpdate();
							
					connect.prepareStatement("select * from livre") ;
						

					

				

			}
				catch (Exception e) {
					System.out.println("LivreDAO: create() failed: "+e.getLocalizedMessage());
				}
				
				
				return null;
			}

			@Override
			public ObservableList<Livre> update(Livre obj) {
				// TODO Auto-generated method stub
				return null;
			}

			
// Creation de la methode Supprimer qui herite de DAO//
			@Override
			public  ObservableList <Livre>  delete(Livre obj) {


				try {
					Statement stmt = connect.createStatement();
					stmt.executeUpdate("delete from livre where titre='"+obj.getTitre()+"';");

					ObservableList <Livre> listliv = FXCollections.observableArrayList();
					

					ResultSet rs = stmt.executeQuery("select * from livre") ;
					while (rs.next()) {
						Livre liv = new Livre();
						String bd_titre = rs.getString("titre");
						String bd_editeur = rs.getString("editeur");
						String bd_auteur = rs.getString("auteur");
						int bd_année = rs.getInt("annee");
						String bd_type = rs.getString("type");

						liv.setTitre(bd_titre);
						liv.setEditeur(bd_editeur);
						liv.setAuteur(bd_auteur);
						liv.setAnnee(bd_année);
						liv.setType(bd_type);

						
						listliv.add(liv);
					}
					
					return listliv;
						
					}

				
				catch (Exception e) {
					System.out.println("LivreDAO: delete() failed: "+e.getLocalizedMessage());
				}
				return null;

			}

			
				
			}

