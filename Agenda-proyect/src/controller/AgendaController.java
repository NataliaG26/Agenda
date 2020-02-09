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
import javafx.scene.layout.RowConstraints;
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
    private RowConstraints row_cBox_OtherOption;

    @FXML
    private RowConstraints row_txtF_Search;

    @FXML
    private RowConstraints row_HBox_FirstDateContainer;

    @FXML
    private RowConstraints row_HBox_SecondDateContainer;

    @FXML
    private RowConstraints row_btn_Search;

    @FXML
    private RowConstraints row_listView_Contacts;

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
    
    //muestra mas opciones dependiendo de la opcion seleccionada
    //habilita los nodos correspondientes
    @FXML
    void changeCBoxPrincipal(ActionEvent event) {
    	
    }
    
    //muestra mas opciones dependiendo de la opcion seleccionada
    //habilita los nodos correspondientes
    @FXML
    void changeCBoxOtherOption(ActionEvent event) {
    	
    }
    
    //muestra el menu con las opciones de ordenamiento
    @FXML
    void orderPage(MouseEvent event) {
    	
    }
    
    //realiza el filtro con las espesificaciones dadas por el usuario
    //realizar verificacion de fechas, numeros y que los txtF contengan algo
    @FXML
    private void search(ActionEvent event) {
    	//realizar el filtro 
    	//lista con la info de los contactos a mostrar
    }
    

    //muestra en el menau las opciones de busqueda y filtrado
    @FXML
    private void searchPage(MouseEvent event) {
    	setVisual_InitialSearchPage();
    	setVisual_ShowContacts();
    }
    
    //muestra vista de contacto
    //txtF habilitados para editar
    //esconder simbolos de borrar y editar
    //habilitar signos de check y cancel
    @FXML
    private void newContact(MouseEvent event) {
    	contactController = loadScene("Contact").getController();
    	System.out.println("contact");
    	contactController.setVisualNewContact();
    	
    }
    
    //cambia la ventana del anchorpane y muestra la ventana de contactos con el primer contacto
    private void setVisual_ShowContacts() {
    	contactController = loadScene("Contact").getController();
    	System.out.println("contact");
    	contactController.setVisual_ShowContact();
    	contactController.setVisual_ShowSubject();
    }
    
  //solo deja visible y habilitado el primer comboBox para busqueda
    private void setVisual_InitialSearchPage() {
    	setVisual_InitialPage();
    	cBox_Principal.setPromptText("Buscar...");
    	//cargar las opcines de cBox para busqueda
    }
    
    private void setVisual_InitialOrderPage() {
    	setVisual_InitialPage();
    	cBox_Principal.setPromptText("Ordenar...");
    	//cargar las opcines de cBox para ordenar
    }
    
    //solo deja visible y habilitado el primer comboBox 
    private void setVisual_InitialPage() {
    	cBox_OtherOption.setVisible(false);
		txtF_Search.setVisible(false);
		HBox_FirstDateContainer.setVisible(false);
		HBox_SecondDateContainer.setVisible(false);
		btnSearch.setVisible(false);
		listView_Contacts.setVisible(false);
		
		cBox_OtherOption.setMaxHeight(0);
		txtF_Search.setMaxHeight(0);
		HBox_FirstDateContainer.setMaxHeight(0);
		HBox_SecondDateContainer.setMaxHeight(0);
		btnSearch.setMaxHeight(0);
		listView_Contacts.setMaxHeight(0);
		
		row_cBox_OtherOption.setMaxHeight(0);
		row_txtF_Search.setMaxHeight(0);
		row_HBox_FirstDateContainer.setMaxHeight(0);
		row_HBox_SecondDateContainer.setMaxHeight(0);
		row_btn_Search.setMaxHeight(0);
		row_listView_Contacts.setMaxHeight(0);
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
			setVisual_InitialSearchPage();
			menuContainer2.setVisible(false);
			mainController = null;
			contactController = null;
			summaryController = null;
			//summaryController = loadScene("Summary").getController();
		}

}
