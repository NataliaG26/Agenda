package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class AgendaController implements Initializable{
		
	 	@FXML
	    private BorderPane borderPane;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private VBox menu;

	    @FXML
	    private Button btnMenu;

	    @FXML
	    private Button btnSummary;

	    @FXML
	    private Button btnContacts;

	    @FXML
	    private Region region1;

	    @FXML
	    private Button btn;

	    @FXML
	    private void contacts(ActionEvent event) {
	    	
	    	
	    }
	    
	    //muestra o esconde el menu
	    @FXML
	    private void menu(ActionEvent event) {
	    	
	    	if(menu.getWidth()<168) {
	    		menu.setMinWidth(168);
	    		btnSummary.setVisible(true);
		    	btnContacts.setVisible(true);
		    	region1.setVisible(true);
		    	btn.setVisible(true);
	    	}else {
	    		menu.setMinWidth(40);
	    		btnSummary.setVisible(false);
		    	btnContacts.setVisible(false);
		    	region1.setVisible(false);
		    	btn.setVisible(false);
	    	}
	    	
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			btnSummary.setVisible(false);
	    	btnContacts.setVisible(false);
	    	region1.setVisible(false);
	    	btn.setVisible(false);
		}
	

}
