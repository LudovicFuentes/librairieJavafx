package application.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import application.model.beans.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



	public class LivreDAO extends  DAO<Livre> {
		
		public static ObservableList <Livre> find ( Object value) {
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

			
			public static ObservableList <Livre> findall () {

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
			public Livre create(Livre obj) {
				try {
					Statement stmt = connect.createStatement();
					
					//Ici on insere le nouvel auteur
					String query = "INSERT INTO livre (titre, editeur ,année, type) VALUES ('?', '?', '?', '?');";
					PreparedStatement preparedStatement = connect.prepareStatement(query);
					preparedStatement.setString(1, obj.getTitre());
					preparedStatement.setString(2, obj.getEditeur());
					preparedStatement.setInt(3, obj.getAnnee());
					preparedStatement.setString(4, obj.getType());
					preparedStatement.execute();
					
					// pour récupérer l'objet que l'on vient d'insérer, cette fois avec l'ID auto-généré
					ResultSet rs = stmt.executeQuery("Select * from livre");
					
					//Je me place sur la dernière ligne
					rs.last();
					
					//Puis je fais comme avant (comme pour find() et findByName() )
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
					return liv;
				
				}
				catch (Exception e) {
					System.out.println("LivreDAO: create() failed: "+e.getLocalizedMessage());
				}
				
				
				return null;
			}

			@Override
			public Livre update(Livre obj) {
				// TODO Auto-generated method stub
				return null;
			}

			

			@Override
			public void delete(Livre obj) {


				try {
					Statement stmt = connect.createStatement();
					stmt.executeQuery("delete from auteur where id="+obj.getTitre()+";");

						
						
					System.out.println("Livre supprimé avec succés!!!!");
					}

				
				catch (Exception e) {
					System.out.println("LivreDAO: delete() failed: "+e.getLocalizedMessage());
				}
				

			}
				
			}

