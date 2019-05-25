package application.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import application.model.beans.Auteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



	public class AuteurDAO extends  DAO<Auteur> {
		
//Creation d'une methode find de paramétre Object value qui permettra de pouvoir mettre le value clause à plusieur endroit, etant donnée//
//que nous effectuons une recherche sur plusieurs element de la table mais avec 1 seul textfield//
		public  ObservableList <Auteur> find(Object value) {
			String valueClause = value.toString();
			//Creation de l'observablelist utile pour pouvoir mettre les informations dans le table view//
			ObservableList <Auteur> autlist = FXCollections.observableArrayList();
		
				try {
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("select * from auteur where nom= '"+valueClause+"' or  prenom= '"+valueClause+"'or pays= '"+valueClause+"';");
					while (rs.next()) {
						//Creation d'un objet Auteur qui va permettre de recupérer les valeurs de la BDD//
						Auteur aut = new Auteur();
						String bd_nom = rs.getString("nom");
						String bd_prenom = rs.getString("prenom");
						String bd_pays = rs.getString("pays");


						aut.setNom(bd_nom);
						aut.setPrenom(bd_prenom);
						aut.setPays(bd_pays);


						
						autlist.add(aut);
					}
					
					return autlist;
				}
				catch (Exception e) {
					System.out.println("AuteurDAO: find() failed: "+e.getLocalizedMessage());
				}
				
				return null;
				
			}

		
// Creation de la methode findall qui herite de DAO//
			@Override
			public  ObservableList <Auteur> findall() {

				ObservableList <Auteur> autlist = FXCollections.observableArrayList();
			
					try {
						Statement stmt = connect.createStatement();
						ResultSet rs = stmt.executeQuery("select * from auteur") ;
						while (rs.next()) {
							//Creation d'un objet Auteur qui va permettre de recupérer les valeurs de la BDD//
							Auteur aut = new Auteur();
							String bd_nom = rs.getString("nom");
							String bd_prenom = rs.getString("prenom");
							String bd_pays = rs.getString("pays");


							aut.setNom(bd_nom);
							aut.setPrenom(bd_prenom);
							aut.setPays(bd_pays);


							
							autlist.add(aut);
						}
						
						return autlist;
					}
					catch (Exception e) {
						System.out.println("AuteurDAO: findall() failed: "+e.getLocalizedMessage());
					}
					
					return null;
					
				}
// Methode pour creer qui herite de DAO//
			@Override
			public ObservableList <Auteur> Create (Auteur Obj) {

				try {
					
					//Ici on insere le nouveau livre//
					PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO auteur(nom,prenom,pays) VALUES ( ?, ?, ?)");
					preparedStatement .setString( 1, Obj.getNom() );   
					preparedStatement .setString( 2, Obj.getPrenom() );   
					preparedStatement .setString( 3, Obj.getPays() );     
					preparedStatement .executeUpdate();
							
					connect.prepareStatement("select * from auteur") ;
						

					

				

			}
				catch (Exception e) {
					System.out.println("AuteurDAO: create() failed: "+e.getLocalizedMessage());
				}
				
				
				return null;
			}

			@Override
			public ObservableList<Auteur> update(Auteur obj) {
				// TODO Auto-generated method stub
				return null;
			}

			
// Creation de la methode Supprimer qui herite de DAO//
			@Override
			public  ObservableList <Auteur>  delete(Auteur obj) {


				try {
					Statement stmt = connect.createStatement();
					stmt.executeUpdate("delete from auteur where nom='"+obj.getNom()+"';");

					ObservableList <Auteur> autlist = FXCollections.observableArrayList();
					

					ResultSet rs = stmt.executeQuery("select * from auteur") ;
					while (rs.next()) {
						//Creation d'un objet Auteur qui va permettre de recupérer les valeurs de la BDD//
						Auteur aut = new Auteur();
						String bd_nom = rs.getString("nom");
						String bd_prenom = rs.getString("prenom");
						String bd_pays = rs.getString("pays");


						aut.setNom(bd_nom);
						aut.setPrenom(bd_prenom);
						aut.setPays(bd_pays);


						
						autlist.add(aut);
					}
					
					return autlist;
				}
				catch (Exception e) {
					System.out.println("AuteurDAO: delete() failed: "+e.getLocalizedMessage());
				}
				
				return null;
				
			}
			
				
			}

