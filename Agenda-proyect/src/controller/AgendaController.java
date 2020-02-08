package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
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
	    private ComboBox<?> cBox_Filter;

	    @FXML
	    private ListView<?> listView_Contacts;

	    @FXML
	    private Button btnNewContact;
	    
	    //
	    @FXML
	    private void contacts(ActionEvent event) {
	    	loadScene("Contacts");
	    	System.out.println("Contacts");
	    }
	    
	    
	    //muestra la scena de Summary
	    @FXML
	    private void summary(ActionEvent event) {
	    	loadScene("Summary");
	    	System.out.println("summary");
	    }
	    
	    //carga la scene en el anchor pane
	    //page is the name of scene
	    private void loadScene(String page) {
	    	Parent root = null;
	    	try {
	    		root = FXMLLoader.load(getClass().getResource("..\\ui\\"+page+".fxml"));
	    	}catch(IOException ex){
	    		System.err.println(ex);
	    	}
	    	borderPane.setCenter(root);
	    }
	    
	    //muestra o esconde el menu
	    @FXML
	    private void menu(MouseEvent  event) {
	    	
	    	if(menu.getWidth()<168) {
	    		menu.setMinWidth(168);
	    		btnSummary.setVisible(true);
		    	btnContacts.setVisible(true);
		    	region1.setVisible(true);
		    	btnNewContact.setVisible(true);
	    	}else {
	    		menu.setMinWidth(40);
	    		btnSummary.setVisible(false);
		    	btnContacts.setVisible(false);
		    	region1.setVisible(false);
		    	btnNewContact.setVisible(false);
	    	}
	    	
	    	
	    }
	  

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			btnSummary.setVisible(false);
	    	btnContacts.setVisible(false);
	    	region1.setVisible(false);
	    	btnNewContact.setVisible(false);
		}
	

}
