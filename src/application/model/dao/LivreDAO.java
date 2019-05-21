package application.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import application.model.beans.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



	public class LivreDAO extends  DAO<Livre> {
		

		public  ObservableList <Livre> find(Object value) {
			String valueClause = value.toString();
			ObservableList <Livre> listliv = FXCollections.observableArrayList();
		
				try {
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("select * from livre where titre= '"+valueClause+"' or  auteur= '"+valueClause+"'or editeur= '"+valueClause+"' or annee='"+valueClause+"'or type='"+valueClause+"';");
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
					System.out.println("LivreDAO: find() failed: "+e.getLocalizedMessage());
				}
				
				return null;
				
			}

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
@Override
			public ObservableList <Livre> Create (Livre Obj) {

				try {
					
					//Ici on insere le nouvel auteur
					PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO livre(titre,auteur,annee,editeur,type) VALUES ( ?, ?, ?, ?, ?)");
					preparedStatement .setString( 1, Obj.getTitre() );   
					preparedStatement .setString( 2, Obj.getAuteur() );   
					preparedStatement .setInt( 3, Obj.getAnnee() );   
					preparedStatement .setString( 4, Obj.getEditeur() );   
					preparedStatement .setString( 5, Obj.getType() );   
					preparedStatement .executeUpdate();
							
					preparedStatement.execute();
					
					ObservableList <Livre> listliv = FXCollections.observableArrayList();
					

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
					System.out.println("LivreDAO: create() failed: "+e.getLocalizedMessage());
				}
				
				
				return null;
			}

			@Override
			public ObservableList<Livre> update(Livre obj) {
				// TODO Auto-generated method stub
				return null;
			}

			

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

