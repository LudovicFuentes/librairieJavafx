package application.view;


import application.model.beans.Livre;
import application.model.dao.LivreDAO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class LivreController {
	 @FXML
	    private TableView<Livre> LivreTable = new TableView<>();
	 @FXML
	    private TableColumn<Livre, String>  LivTitreColumn;
	 @FXML
	    private TableColumn<Livre, String>  LivAuteurColumn;
	 @FXML
	    private TableColumn<Livre, Integer> LivAnneeColumn;
	 @FXML
	    private TableColumn<Livre, String> LivEditeurColumn;
	 @FXML
	 	private TableColumn<Livre,String> LivTypeColumn;
	 @FXML
		private TableColumn<Livre, Livre> LivSupprimerColumn = new TableColumn<>("Supprimer");
	 @FXML
	 	private TextField tfRechercher;
	 @FXML
	 	private TextField tfTitre;
	 @FXML
	 	private TextField tfAuteur;
	 @FXML
	 	private TextField tfAnnee;
	 @FXML
	 	private TextField tfEditeur;
	 @FXML
	 	private TextField tfType;


	 
	 public void initialize() {

			try {	

				LivTitreColumn.setCellValueFactory(new PropertyValueFactory<Livre, String>("Titre"));;
				LivAuteurColumn.setCellValueFactory(new PropertyValueFactory<Livre, String>("Auteur"));
				LivAnneeColumn.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("Annee"));
				LivEditeurColumn.setCellValueFactory(new PropertyValueFactory<Livre, String>("Editeur"));
				LivTypeColumn.setCellValueFactory(new PropertyValueFactory<Livre, String>("Type"));
				
// Nous Voulons creer une colonne avec un bouton Supprimer on paramétre une nouvelle colonne du tableau avec des parametre specifique//	
				LivSupprimerColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
				LivSupprimerColumn.setCellFactory(param -> new TableCell<Livre,Livre>() {
			    private final Button deleteButton = new Button("Supprimer");
			    
// Methode qui permet d'afficher le bouton si la ligne est vide ou non //			    
			    @Override
				protected void updateItem(Livre livre, boolean empty) {
			         super.updateItem(livre, empty);
			         LivreDAO livredao = new LivreDAO();
			         if (livre == null) {
			             setGraphic(null);
			             return;
			         }
			         else {
			                setGraphic(deleteButton);
			                deleteButton.setOnAction(event -> LivreTable.getItems().setAll(livredao.delete(livre)));			     }
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
	        LivreDAO livredao = new LivreDAO();
	    	try {

	    		LivreTable.getItems().setAll(livredao.find(text1));
	        	


	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	    	
	    } 
	 // Methode qui definie le comportement du bouton lier à findall() du DAO//
	    public void HandleButtonRechercherTout() {
	        LivreDAO livredao = new LivreDAO();
	    	try {
	    		LivreTable.getItems().setAll(livredao.findall());
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	 // Methode qui definie le comportement du bouton lier à create() du DAO//
	    public  void HandleButtonAjouter () {
			int annee = Integer.valueOf(tfAnnee.getText());
	        LivreDAO livredao = new LivreDAO();
	    	try {
	    		Livre livre = new Livre();
	    		
	    		livre.setTitre(tfTitre.getText());
	    		livre.setAuteur(tfAuteur.getText());
	    		livre.setAnnee(annee);
	    		livre.setEditeur(tfEditeur.getText());
	    		livre.setType(tfType.getText());
	    		

	    		
	    		livredao.Create(livre);
	    		
	    		LivreTable.getItems().setAll(livre);
	    		
	        } catch (Exception e) {
	        	e.printStackTrace();

	        }
	    }
}
