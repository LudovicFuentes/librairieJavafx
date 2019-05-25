package application.view;


import java.io.FileInputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BonjourController {

	public void HandleButtonLivre() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrairieView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}

	public void HandleButtonTruth() {
        try {
        	Image image = new Image(new FileInputStream("C:\\Users\\LFuentes\\Desktop\\truth.png"));  
            
 
            ImageView imageView = new ImageView(image); 
            
            //Setting the position of the image 
            imageView.setX(50); 
            imageView.setY(25); 
            
            //setting the fit height and width of the image view 
            imageView.setFitHeight(455); 
            imageView.setFitWidth(500); 
            
            //Setting the preserve ratio of the image view 
            imageView.setPreserveRatio(true);  
            
            //Creating a Group object  
            Group root = new Group(imageView);  
            
            //Creating a scene object 
            Scene scene = new Scene(root, 600, 500);  
            Stage stage = new Stage();
            //Setting title to the Stage 
            stage.setTitle("Loading an image");  
            
            //Adding scene to the stage 
            stage.setScene(scene);
            
            //Displaying the contents of the stage 
            stage.show(); 
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
}

