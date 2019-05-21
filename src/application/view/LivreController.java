package application.view;

import application.model.beans.Livre;
import application.model.dao.LivreDAO;
import application.model.dao.LivreSearchType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class LivreController{
	 @FXML
	    private ChoiceBox<LivreSearchType> choiceBox;
	 @FXML
	    private TableView<Livre> LivreTable;
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
	 	private TextField tfRechercher;
	 @FXML
	 	private TextField tfAjouter;


	
	 
	 
	 public void initialize() {

			try {	

				LivTitreColumn.setCellValueFactory(cellData -> cellData.getValue().TitreProperty());
				LivAuteurColumn.setCellValueFactory(cellData -> cellData.getValue().AuteurProperty());
				LivAnneeColumn.setCellValueFactory(cellData -> cellData.getValue().AnneeProperty().asObject());
				LivEditeurColumn.setCellValueFactory(cellData -> cellData.getValue().EditeurProperty());
				LivTypeColumn.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
				

			} catch(Exception e) {
				System.out.println(" initialize() failed: " + e);
				e.printStackTrace();
			}

		}




	    @FXML
	    public  void HandleButtonRecherche () {
	        String text = tfRechercher.getText();
	    	try {

	    		LivreTable.getItems().setAll(LivreDAO.find(text));
	        	

	        } catch (Exception e) {
	            e.printStackTrace();

	        }

	    } 
	    public void HandleButtonRechercherTout() {
	    	try {
	    		LivreTable.getItems().setAll(LivreDAO.findall());
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

}
