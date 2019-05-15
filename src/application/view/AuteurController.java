
package application.view;

import application.model.beans.Auteur;
import application.model.dao.AuteurDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AuteurController {
	@FXML
	private Label labelNom;
	
	@FXML
	private Label labelPrenom;
	
	@FXML
	private Label labelPays;
	@FXML
	private Label labelDateNaissance;	
	@FXML
	private Label labelID;	
	@FXML
	private Label labelDateDeces;
	@FXML
	private TextField tfID;
	
	//on va chercher l'id demand� par l'utilisateur dans le textfield,
	int num = Integer.valueOf(tfID.getText());


	//M�thode publique permettant, � partir d'un objet �tudiant, de me remplir les bons label sur l'interface
	public void fillView(Auteur a) {
		labelNom.setText(a.getNom());
		labelPrenom.setText(a.getPrenom());
		labelPays.setText(a.getPays());
		


	}
	
	//r�action au clic sur le bouton: on va chercher l'id demand� par l'utilisateur dans le textfield,
	//on utilise le DAO pour aller chercher le bon objet Etudiant,
	//puis on met � jour les labels
	public void onButtonClicked() {
		System.out.println("fais");
		
		//on va chercher l'id demand� par l'utilisateur dans le textfield,
		int num = Integer.valueOf(tfID.getText());
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		AuteurDAO etdao = new AuteurDAO();
		Auteur et = etdao.find(num);
		
		
		System.out.println(et);
		//puis on met � jour les labels
		this.fillView(et);
		

		
	}
	

}