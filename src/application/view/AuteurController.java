package application.view;

import application.model.beans.Auteur;
import application.model.dao.AuteurDAO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class AuteurController {
	 @FXML
	    private TableView<Auteur> AuteurTable = new TableView<>();
	 @FXML
	    private TableColumn<Auteur, String>  AutNomColumn;
	 @FXML
	    private TableColumn<Auteur, String>  AutPrenomColumn;
	 @FXML
	    private TableColumn<Auteur, Integer> AutPaysColumn;
	 @FXML
		private TableColumn<Auteur, Auteur> AutSupprimerColumn = new TableColumn<>("Supprimer");
	 @FXML
	 	private TextField tfRechercher;
	 @FXML
	 	private TextField tfNom;
	 @FXML
	 	private TextField tfPrenom;
	 @FXML
	 	private TextField tfPays;



	 
	 public void initialize() {

			try {	

				AutNomColumn.setCellValueFactory(new PropertyValueFactory<Auteur, String>("Nom"));;
				AutPrenomColumn.setCellValueFactory(new PropertyValueFactory<Auteur, String>("Prenom"));
				AutPaysColumn.setCellValueFactory(new PropertyValueFactory<Auteur, Integer>("Pays"));

// Nous Voulons creer une colonne avec un bouton Supprimer on paramétre une nouvelle colonne du tableau avec des parametre specifique//	
				AutSupprimerColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
				AutSupprimerColumn.setCellFactory(param -> new TableCell<Auteur,Auteur>() {
			    private final Button deleteButton = new Button("Supprimer");
			    
// Methode qui permet d'afficher le bouton si la ligne est vide ou non //			    
			    @Override
				protected void updateItem(Auteur auteur, boolean empty) {
			         super.updateItem(auteur, empty);
			         AuteurDAO auteurdao = new AuteurDAO();
			         if (auteur == null) {
			             setGraphic(null);
			             return;
			         }
			         else {
			                setGraphic(deleteButton);
			                deleteButton.setOnAction(event -> AuteurTable.getItems().setAll(auteurdao.delete(auteur)));			     }
			    }
				});
				

			} catch(Exception e) {
				System.out.println(" initialize() failed: " + e);
				e.printStackTrace();
			}

		

	 }

 

// Methode qui definie le comportement du bouton lier à find() du DAO//
	    public  void HandleButtonRecherche () {
	        String text1 = tfRechercher.getText();
	        AuteurDAO auteurdao = new AuteurDAO();
	    	try {

	    		AuteurTable.getItems().setAll(auteurdao.find(text1));
	        	


	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	    	
	    } 
	 // Methode qui definie le comportement du bouton lier à findall() du DAO//
	    public void HandleButtonRechercherTout() {
	        AuteurDAO auteurdao = new AuteurDAO();
	    	try {
	    		AuteurTable.getItems().setAll(auteurdao.findall());
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	 // Methode qui definie le comportement du bouton lier à create() du DAO//
	    public  void HandleButtonAjouter () {

	        AuteurDAO auteurdao = new AuteurDAO();
	    	try {
	    		Auteur auteur = new Auteur();
	    		
	    		auteur.setNom(tfNom.getText());
	    		auteur.setPrenom(tfPrenom.getText());
	    		auteur.setPays(tfPays.getText());

	    		

	    		
	    		auteurdao.Create(auteur);
	    		
	    		AuteurTable.getItems().setAll(auteur);
	    		
	        } catch (Exception e) {
	        	e.printStackTrace();

	        }
	    }
}
