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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AgendaController implements Initializable{
		

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox menu;

    @FXML
    private HBox menuContainer2;

    @FXML
    private ComboBox<?> cBox_Principal;

    @FXML
    private ComboBox<?> cBox_OtherOption;

    @FXML
    private TextField txtF_Search;

    @FXML
    private HBox HBox_FirstDateContainer;

    @FXML
    private HBox HBox_SecondDateContainer;

    @FXML
    private Button btnSearch;

    @FXML
    private ListView<?> listView_Contacts;

    @FXML
    private ImageView imagen_search;

    @FXML
    private ImageView image_Order;

    @FXML
    private ImageView image_AddContact;

    @FXML
    private ImageView image_Summary;

    @FXML
    private AnchorPane anchorPane;
    
    private MainController mainController;
    
    private ContactController contactController;
    
    private SummaryController summaryController;
    
    
    @FXML
    void changeCBoxOtherOption(ActionEvent event) {

    }

    @FXML
    void changeCBoxPrincipal(ActionEvent event) {

    }

    @FXML
    void orderPage(MouseEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }
    
    //muestra vista de contacto
    //txtF habilitados para editar
    //esconder simbolos de borrar y editar
    //habilitar signos de check y cancel
    @FXML
    void newContact(MouseEvent event) {
    	contactController = loadScene("Contact").getController();
    	System.out.println("summary");
    	contactController.setVisualNewContact();
    	
    }

    //muestra en el menau las opciones de busqueda y filtrado
    @FXML
    void searchPage(MouseEvent event) {
    	
    }

	    
	    //muestra la scena de Summary
	    @FXML
	    private void summary(MouseEvent event) {
	    	summaryController = loadScene("Summary").getController();
	    	System.out.println("summary");
	    }
	    
	    //carga la scene en el anchor pane
	    //page is the name of scene
	    private FXMLLoader loadScene(String page) {
	    	Parent root = null;
	    	FXMLLoader loader = null;
	    	try {
	    		loader = new FXMLLoader(getClass().getResource("..\\ui\\"+page+".fxml"));
	    		root = loader.load();
	    		mainController.conection(loader, page);
	    	}catch(IOException ex){
	    		System.err.println(ex);
	    	}
	    	borderPane.setCenter(root);
	    	return loader;
	    }
	    
	    //muestra o esconde el menu
	    @FXML
	    private void menu(MouseEvent  event) {
	    	
	    	if(menu.getWidth()<=40) {
	    		menu.setMinWidth(225);
	    		menuContainer2.setVisible(true);
	    	}else {
	    		menuContainer2.setVisible(false);
	    		menu.setMinWidth(40);	    	
	    	}
	    		  	
	    }
	    
	    
	    //cambia el objeto main controller para realizar la coneccion con la clase controladora principal de
	    public void setMainController(MainController mainController) {
			this.mainController = mainController;
		}
	  

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			menu.setMinWidth(40);
			menuContainer2.setVisible(false);
			mainController = null;
			contactController = null;
			summaryController = null;
		}
	

}
