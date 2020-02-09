package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Agenda;
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
    private ComboBox<String> cBox_Principal;

    @FXML
    private ComboBox<String> cBox_OtherOption;

    @FXML
    private TextField txtF_Search;

    @FXML
    private HBox HBox_FirstDateContainer;

    @FXML
    private HBox HBox_SecondDateContainer;

    @FXML
    private Button btnSearch;

    @FXML
    private ListView<String> listView_Contacts;

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
    
    private final static double HEIGHT_ROW = 35;
    
    //private 
    
    /*
     * 
     */
    
    //muestra mas opciones dependiendo de la opcion seleccionada
    //habilita los nodos correspondientes
    @FXML
    void changeCBoxPrincipal(ActionEvent event) {
    	String selected = cBox_Principal.getValue();
    	switch (selected){
    	case Agenda.SEARCH_NAME:
    		setVisual_SearchName();
    		break;
    	case Agenda.SEARCH_AGE:
    		setVisual_SearchAge();
    		break;
    	case Agenda.SEARCH_BIRTHDAY:
    		setVisual_SearchBirthday();
    		break;
    	case Agenda.SEARCH_SUBJECT:
    		setVisual_SearchSubject();
    		break;
    	case Agenda.ORDER_NAME:
    		setVisual_OrderName();
    		break;
    	case Agenda.ORDER_AGE:
    		setVisual_OrderAge();
    		break;
    	case Agenda.ORDER_BIRTHDAY:
    		setVisual_OrderBirthday();
    		break;
    	}
    }
    
    //muestra mas opciones dependiendo de la opcion seleccionada
    //habilita los nodos correspondientes
    @FXML
    void changeCBoxOtherOption(ActionEvent event) {
    	
    }
    
    //muestra el menu con las opciones de ordenamiento
    @FXML
    void orderPage(MouseEvent event) {
    	setVisual_InitialOrderPage();
    	//ordenar todos por nombre y mostrar todos
    	setVisual_ShowContacts();
    }
    
    //realiza el filtro con las espesificaciones dadas por el usuario
    //realizar verificacion de fechas, numeros y que los txtF contengan algo
    @FXML
    private void search(ActionEvent event) {
    	//realizar el filtro 
    	//lista con la info de los contactos a mostrar
    	actualizeListView_Contacts();
    	
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
    	contactController = loadScene(MainController.ID_CONTACTS).getController();
    	System.out.println("contacts");
    	contactController.setVisualNewContact();
    	contactController.setVisual_ShowSubjectNotSelected();
    	
    }
    
    /////////////////actualize visible lists//////////////////////////
    
    /*
     * Actualize the listView_Contacts for to show contacts
     */
    private void actualizeListView_Contacts() {
    	ObservableList<String> list = FXCollections.observableArrayList(mainController.getContactsName());
    	listView_Contacts.setItems(list);
    }
    
    /*
     * Actualize the 
     */
    private void actualizeCBox_Principal_ForSearch() {
    	ObservableList<String> list = FXCollections.observableArrayList(mainController.getSearchOptions());
    	cBox_Principal.setItems(list);
    }
    
    /*
     * Actualize the 
     */
    private void actualizeCBox_Principal_ForOrder() {
    	ObservableList<String> list = FXCollections.observableArrayList(mainController.getOrderOptions());
    	cBox_Principal.setItems(list);
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////
    
    /////////////////////SET VISUAL ////////////////////////////////
    
    
    private void setVisual_SearchName() {
    	row_txtF_Search.setMinHeight(HEIGHT_ROW);
    	txtF_Search.setVisible(true);
    	txtF_Search.setEditable(true);
    }
    
    private void setVisual_SearchAge() {
    	row_txtF_Search.setMinHeight(HEIGHT_ROW);
    	txtF_Search.setVisible(true);
    	txtF_Search.setEditable(true);
    	
    }
    
    private void setVisual_SearchBirthday() {
    	
    }
    
    private void setVisual_SearchSubject() {
    	
    }
    
    private void setVisual_OrderName() {
    	
    }
    
    private void setVisual_OrderAge() {
    	
    }

	private void setVisual_OrderBirthday() {
	
	}
    
    //cambia la ventana del anchorpane y muestra la ventana de contactos con el primer contacto
    private void setVisual_ShowContacts() {
    	contactController = loadScene(MainController.ID_CONTACTS).getController();
    	System.out.println("contacts");
    	contactController.setVisual_ShowContact();
    	contactController.setVisual_ShowSubjectNotSelected();
    }
    
  //solo deja visible y habilitado el primer comboBox para busqueda
    private void setVisual_InitialSearchPage() {
    	setVisual_InitialPage();
    	cBox_Principal.setPromptText("Buscar...");
    	actualizeCBox_Principal_ForSearch();
    	//cargar las opcines de cBox para busqueda
    }
    
    private void setVisual_InitialOrderPage() {
    	setVisual_InitialPage();
    	cBox_Principal.setPromptText("Ordenar...");
    	actualizeCBox_Principal_ForOrder();
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
    
    
    /////////////////////////////////////////////////////////////////////////////////
	    
	    //muestra la scena de Summary
	    @FXML
	    private void summary(MouseEvent event) {
	    	summaryController = loadScene(MainController.ID_SUMMARY).getController();
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
