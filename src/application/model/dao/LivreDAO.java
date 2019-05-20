package application.model.dao;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
	import java.util.ArrayList;


import application.model.beans.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

	public class LivreDAO extends  DAO<Livre> {
		
		public ObservableList<Livre> fetchEntries() {

			// On récupère les tuples de la BDD
			try {

				//On va les stocker dans une liste
				ObservableList<Livre> livre = FXCollections.observableArrayList();

				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM livre");

				while (rs.next()) {

					Livre currentItem = new Livre();

					String bd_titre = rs.getString("titre");
					String bd_editeur = rs.getString("editeur");
					String bd_auteur = rs.getString("auteur");
					int bd_année = rs.getInt("année");
					String bd_type = rs.getString("type");
							
					rs.getString("titre");
					rs.getString("Editeur");
					rs.getString("Auteur");
					rs.getInt("annee");
					rs.getString("type");
							
							
							livre.add(currentItem);

				}

				return livre;

			} catch (Exception e) {
				System.out.println("AlimentDAO: fetchEntries() failed: " + e);
				e.printStackTrace();
			}

			return null;
		}



			//Premiere méthode find. Renvoie un auteur connaissant son identifiant.
			@Override
			 public  ObservableList<Livre> findall() {
		        //Declare a SELECT statement

		 
		        //Execute SELECT statement
		        try {
		            //Get ResultSet from dbExecuteQuery method
		            Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM livre");
		 
		            //Send ResultSet to the getEmployeeList method and get employee object
		            ObservableList<Livre> LivreList = getLivreList(rs);
		 
		            //Return employee object
		            return LivreList;
		        } catch (Exception e) {
		            System.out.println("SQL select operation has been failed: " + e);

		        }
				return null;
		    }
		 
		    //Select * from employees operation
		    public ObservableList<Livre> getLivreList(ResultSet rs)  {
		        //Declare a observable List which comprises of Employee objects
		        ObservableList<Livre> LivreList = FXCollections.observableArrayList();
		 try {
		        while (rs.next()) {
					Livre liv = new Livre();
					String bd_titre = rs.getString("titre");
					String bd_editeur = rs.getString("editeur");
					String bd_auteur = rs.getString("auteur");
					int bd_année = rs.getInt("année");
					String bd_type = rs.getString("type");

					liv.setTitre(bd_titre);
					liv.setEditeur(bd_editeur);
					liv.setAuteur(bd_auteur);
					liv.setAnnee(bd_année);
					liv.setType(bd_type);

					LivreList.add(liv);

				}
				return LivreList;
			}
			catch (Exception e) {
				System.out.println("LivreDAO: findall() failed: "+e.getLocalizedMessage());
			}
		return null;
		    }
//			//deuxième méthode find. Renvoie la liste des Auteur portant le nom "nom".
			public ArrayList<Livre> findBookByProperty(LivreSearchType searchType, Object value){
				ArrayList<Livre> listliv = new ArrayList<Livre>();
				        String whereClause = "";
				        String valueClause = "";

				        switch (searchType) {
				            case Titre:
				                whereClause = "titre LIKE ?";
				                valueClause = "%" + value.toString() + "%";
				                break;
				            case Editeur:
				                whereClause = "editeur = ?";
				                valueClause = value.toString();
				                break;
				            case Année:
				                whereClause = "année = ?";
				                valueClause = value.toString();
				                break;
				            case Auteur:
				                whereClause = "fk_auteur LIKE ?";
				                valueClause = "%" + value.toString() + "%";
				                break;
				            default:
				                System.out.println("Unknown search type");
				                break;
				        }

				        try {
				            Statement stmt = connect.createStatement();
							ResultSet rs = stmt.executeQuery("SELECT * FROM livre WHERE " + whereClause + valueClause);
							while (rs.next()) {
								Livre liv = new Livre();
								String bd_titre = rs.getString("titre");
								String bd_editeur = rs.getString("editeur");
								String bd_auteur = rs.getString("auteur");
								int bd_année = rs.getInt("année");
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
			public Livre create(Livre obj) {
				try {
					Statement stmt = connect.createStatement();
					
					//Ici on insere le nouvel auteur
					String query = "INSERT INTO livre (titre, editeur ,année, type) VALUES (?, ?, ?, ?);";
					PreparedStatement preparedStatement = connect.prepareStatement(query);
					preparedStatement.setString(1, obj.getTitre());
					preparedStatement.setString(2, obj.getEditeur());
					preparedStatement.setInt(3, obj.getAnnee());
					preparedStatement.setString(2, obj.getType());
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
					int bd_année = rs.getInt("année");
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

