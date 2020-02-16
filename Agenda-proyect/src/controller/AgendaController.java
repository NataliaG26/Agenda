package controller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    private ComboBox<String> cBox_MonthsFirstDate;

    @FXML
    private TextField txtF_DayFirstDate;

	@FXML
	private RowConstraints row_HBox_SecondDateContainer;
	
	@FXML
	private ComboBox<String> cBox_MonthsSecondDate;

	@FXML
	private TextField txtF_DaySecondDate;

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

	@Override
	/**
	 * This method initializes the current controller for the current stage.
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
		menu.setMinWidth(40);
		menuContainer2.setVisible(false);
		mainController = new MainController();
		contactController = null;
		summaryController = null;
		setVisual_InitialSearchPage();
	}
	
	/**
	 * This method sets the maincontroller for this scene in order to manage requested information.
	 * @param mainController the main controller to be set.
	 */
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	/**
	 * This method shows or hides the main menu.
	 * @param event the event triggered by the user.
	 */
	private void menu(MouseEvent  event) {
		if(menu.getWidth()<=40) {
			menu.setMinWidth(225);
			menuContainer2.setVisible(true);
		}else {
			menuContainer2.setVisible(false);
			menu.setMinWidth(40);	    	
		}
	}
	
	@FXML
	/**
	 * This method shows the menu with the sorting options.
	 * <b>Pos:</b> the menu is shown.
	 * @param event the event triggered by the user.
	 */
	void orderPage(MouseEvent event) {
		setVisual_InitialOrderPage();
		//sorts the contacts by name and then shows them on screen.
		showContacts();
	}
	
	@FXML
	/**
	 * This method allows the user to use searching and sorting.
	 * (it shows another options depending on the selected option.)
	 * @param event the event triggered by the user.
	 */
	private void changeCBoxPrincipal(ActionEvent event) {
		setVisual_InitialPage();
		String selected = cBox_Principal.getValue();
		if(selected!=null) {
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
			setVisual_Order();
			break;
		case Agenda.ORDER_AGE:
			setVisual_Order();
			break;
		case Agenda.ORDER_BIRTHDAY:
			setVisual_Order();
			break;
		}
		}
	}
	
	@FXML
	/**
	 * This method shows the extra options for the searching request.
	 * @param event the event triggered by the user.
	 */
	private void changeCBoxOtherOption(ActionEvent event) {
		//setVisual_OtherOption();
		String selected = cBox_OtherOption.getValue();
		switch (selected){
		case Agenda.FILTER_BIRTHDAY:
			setVisual_FilterBirthay();
			break;
		case Agenda.FILTER_BIRTHDAY_BETWEEN_DATES:
			setVisual_FilterBirthdayBetweenDates();
			break;
		case Agenda.FILTER_BIRTHDAY_BETWEEN_MONTHS:
			setVisual_FilterBirthdayBetweenMonths();
			break;
		case Agenda.FILTER_BIRTHDAY_MONTHS:
			setVisual_FilterBirthdayMonth();
			break;
		case Agenda.FILTER_AGE:
			break;
		case Agenda.FILTER_AGE_OLDER:
			break;
		case Agenda.FILTER_AGE_JOUNGER:
			break;
		case Agenda.ORDER_NAME:
			break;
		case Agenda.ORDER_BIRTHDAY:
			break;
		case Agenda.ORDER_AGE:
			break;
		}
		
	}
	
	/**
	 * This method loads the scene to be shown on the main window.
	 * @param page the scene that is going to be loaded.
	 * @return a FXMLLoader that allows to loads the scene with its respective controller.
	 */
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
	
	//cambia la ventana del anchorpane y muestra la ventana de contactos con el primer contacto
	private void showContacts() {
		contactController = loadScene(MainController.ID_CONTACTS).getController();
		contactController.setVisual_ShowContact();
		contactController.setVisual_ShowSubjectNotSelected();
		contactController.setVisual_ListViewSubject();
	}
	
	//muestra vista de contacto
	//txtF habilitados para editar
	//esconder simbolos de borrar y editar
	//habilitar signos de check y cancel
	@FXML
	private void newContact(MouseEvent event) {
		contactController = loadScene(MainController.ID_CONTACTS).getController();
		contactController.setVisualNewContact();
		contactController.setVisual_ShowSubjectNotSelected();
	}
	
	@FXML
	/**
	 * This method shows the summary scene.
	 * <b>Pre:</b> the fxml file of the summary scene exists.
	 * <b>Pos:</b> the summary scene is loaded.
	 * @param event the event triggered by the user.
	 */
	private void summary(MouseEvent event) {
		summaryController = loadScene(MainController.ID_SUMMARY).getController();
		summaryController.setMainController(mainController);
		summaryController.setVisual_ShowSubjectNotSelected();
	}
	
	@FXML
    private void monthSelected(ActionEvent event) {
		
    }
	
	//muestra en el menau las opciones de busqueda y filtrado
	@FXML
	/**
	 * This method shows on the menu the options of searching and filtering
	 * @param event the event triggered by the user.
	 */
	private void searchPage(MouseEvent event) {
		mainController.masterSort(Agenda.ORDER_NAME);
		setVisual_InitialSearchPage();
		showContacts();
		showList();
		//contactController.setVisual_ShowContact();
	}
	
	//realiza el filtro con las espesificaciones dadas por el usuario
	//realizar verificacion de fechas, numeros y que los txtF contengan algo
	@FXML
	/**
	 * This method filters the information with the given specifications.
	 * <b>Pos:</b> the searching entries are updated on screen.
	 * @param event the event triggered by the user.
	 */
	private void search(ActionEvent event) {//********************************boton para buscar
		//realizar el filtro 
		//lista con la info de los contactos a mostrar
		String otherOption = cBox_OtherOption.getValue();
		
		if(cBox_Principal.getValue().equals(Agenda.SEARCH_NAME)) {
			mainController.masterSearch(cBox_Principal.getValue(), txtF_Search.getText(), "", 0, "", 0, "");
		}else if(cBox_Principal.getValue().equals(Agenda.SEARCH_AGE)){
			int day1 = 0;
			int day2 = 0;
			try{
				day1 = Integer.parseInt(txtF_DayFirstDate.getText());
				day2 = Integer.parseInt(txtF_DaySecondDate.getText());
			}catch (Exception e) {
				// TODO: handle exception
			}
			mainController.masterSearch(cBox_Principal.getValue(), cBox_OtherOption.getValue(), txtF_Search.getText(), day1, cBox_MonthsFirstDate.getValue(), day2, cBox_MonthsSecondDate.getValue());
		
			
		}
		else if(cBox_Principal.getValue().equals(Agenda.SEARCH_BIRTHDAY)) {
			
		}
		else if(cBox_Principal.getValue().equals(Agenda.SEARCH_SUBJECT)) {
			
			
		}
		else if(btnSearch.getText().equals("Ordenar")) {
			mainController.masterSort(cBox_Principal.getValue());
			
		}
		updateListView_Contacts();
		showContacts();
		showList();
		row_listView_Contacts.setMinHeight(200);
		listView_Contacts.setVisible(true);
		listView_Contacts.setMinHeight(200);
	}
	
	/////////////////UPDATES VISIBLE LISTS//////////////////////////

	private void updateListView_Contacts() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getContactsName());
		listView_Contacts.setItems(list);
		
	}

	private void updateCBox_Principal_ForSearch() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSearchOptions());
		cBox_Principal.setItems(list);
	}

	private void updateCBox_Principal_ForOrder() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getOrderOptions());
		cBox_Principal.setItems(list);
	}
	
	private void updateCBox_OtherOption_Birthday() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSearchBirthdayOptions());
		cBox_OtherOption.setItems(list);
	}
	
	private void updateCBox_OtherOption_Subject() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSearchSubjectOptions());
		cBox_OtherOption.setItems(list);
	}
	
	private void updateCBox_OtherOption_Age() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSearchAgeOptions());
		cBox_OtherOption.setItems(list);
	}
	
	private void updateCBox(ComboBox<String> comboBox, List<String> options) {
		ObservableList<String> list = FXCollections.observableArrayList(options);
		comboBox.setItems(list);
	}
	
	private void updateCBox_Months(ComboBox<String> comboBox) {
		ObservableList<String> list = FXCollections.observableArrayList(Agenda.MONTHS);
		comboBox.setItems(list);
	}

	/////////////////////SET VISUAL////////////////////////////////
	
	private void showList() {
		listView_Contacts.setVisible(true);
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getContactsName());
		listView_Contacts.setItems(list);
		row_listView_Contacts.setMinHeight(200);
		listView_Contacts.setMinHeight(200);
	}

	private void setVisual_SearchName() {
		row_txtF_Search.setMinHeight(HEIGHT_ROW);
		txtF_Search.setVisible(true);
		txtF_Search.setEditable(true);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		btnSearch.setVisible(true);
		btnSearch.setText("Buscar");
	}

	private void setVisual_SearchAge() {
		row_txtF_Search.setMinHeight(HEIGHT_ROW);
		row_cBox_OtherOption.setMinHeight(HEIGHT_ROW);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		btnSearch.setVisible(true);
		cBox_OtherOption.setVisible(true);
		cBox_OtherOption.setEditable(true);
		txtF_Search.setVisible(true);
		txtF_Search.setEditable(true);
		updateCBox_OtherOption_Age();
	}

	private void setVisual_SearchBirthday() {
		row_cBox_OtherOption.setMinHeight(HEIGHT_ROW);
		cBox_OtherOption.setVisible(true);
		cBox_OtherOption.setEditable(true);
		txtF_Search.setVisible(false);
		txtF_Search.setEditable(false);
		row_txtF_Search.setMaxHeight(0);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		btnSearch.setVisible(true);
		btnSearch.setText("Buscar");
		
		updateCBox_OtherOption_Birthday();
	}
	
	private void setVisual_FilterBirthdayBetweenMonths() {
		setVisual_FilterBirthdayBetweenDates();
		txtF_DayFirstDate.setVisible(false);
		txtF_DayFirstDate.setEditable(false);
		txtF_DaySecondDate.setVisible(false);
		txtF_DaySecondDate.setEditable(false);
		updateCBox_Months(cBox_MonthsFirstDate);
		updateCBox_Months(cBox_MonthsSecondDate);
	}
	
	private void setVisual_FilterBirthdayMonth() {
		setVisual_FilterBirthdayBetweenDates();
		txtF_DayFirstDate.setVisible(false);
		txtF_DayFirstDate.setEditable(false);
		setVisual_disableSecondDate();
		updateCBox_Months(cBox_MonthsFirstDate);
	}

	private void setVisual_SearchSubject() {
		row_cBox_OtherOption.setMinHeight(HEIGHT_ROW);
		cBox_OtherOption.setVisible(false);
		cBox_OtherOption.setEditable(false);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		txtF_Search.setVisible(true);
		txtF_Search.setEditable(true);
		row_txtF_Search.setMaxHeight(0);
		btnSearch.setVisible(true);
		btnSearch.setText("Buscar");
		//updateCBox_OtherOption_Subject();
	}

	private void setVisual_Order() {
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		btnSearch.setVisible(true);
		btnSearch.setText("Ordenar");
	}
	
	private void setVisual_FilterBirthay() {
		row_HBox_FirstDateContainer.setMinHeight(HEIGHT_ROW);
		HBox_FirstDateContainer.setVisible(true);
		row_HBox_SecondDateContainer.setMaxHeight(0);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		setVisual_disableSecondDate();
		txtF_DayFirstDate.setVisible(true);
		txtF_DayFirstDate.setEditable(true);
		btnSearch.setVisible(true);
		btnSearch.setText("Buscar");
	}
	
	private void setVisual_disableSecondDate() {
		row_HBox_SecondDateContainer.setMaxHeight(0);
		HBox_SecondDateContainer.setMaxHeight(0);
		//txtF_DaySecondDate.setMaxHeight(0);
		//cBox_MonthsSecondDate.setMaxHeight(0);
		txtF_DaySecondDate.setVisible(false);
		txtF_DaySecondDate.setEditable(false);
		cBox_MonthsSecondDate.setVisible(false);
		cBox_MonthsSecondDate.setEditable(false);
		
	}
	
	private void setVisual_ableSecondDate() {
		row_HBox_SecondDateContainer.setMaxHeight(HEIGHT_ROW);
		HBox_SecondDateContainer.setMaxHeight(HEIGHT_ROW);
		//txtF_DaySecondDate.setMinHeight();
		//cBox_MonthsSecondDate.setMaxHeight(HEIGHT_ROW);
		txtF_DaySecondDate.setVisible(true);
		txtF_DaySecondDate.setEditable(true);
		cBox_MonthsSecondDate.setVisible(true);
		
	}
	
	private void setVisual_FilterBirthdayBetweenDates() {
		setVisual_FilterBirthay();
		setVisual_ableSecondDate();
		row_HBox_SecondDateContainer.setMinHeight(HEIGHT_ROW);
		HBox_SecondDateContainer.setVisible(true);
		row_btn_Search.setMinHeight(HEIGHT_ROW);
		txtF_DayFirstDate.setVisible(true);
		txtF_DayFirstDate.setEditable(true);
		txtF_DaySecondDate.setVisible(true);
		txtF_DaySecondDate.setEditable(true);
		btnSearch.setVisible(true);
		btnSearch.setText("Buscar");
		updateCBox_Months(cBox_MonthsFirstDate);
		updateCBox_Months(cBox_MonthsSecondDate);
	}

	//solo deja visible y habilitado el primer comboBox para busqueda
	private void setVisual_InitialSearchPage() {
		setVisual_InitialPage();
		cBox_Principal.setPromptText("Buscar...");
		updateCBox_Principal_ForSearch();
		//cargar las opcines de cBox para busqueda
	}

	private void setVisual_InitialOrderPage() {
		setVisual_InitialPage();
		cBox_Principal.setPromptText("Ordenar...");
		updateCBox_Principal_ForOrder();
		//cargar las opcines de cBox para ordenar
	}

	//solo deja visible y habilitado el primer comboBox 
	private void setVisual_InitialPage() {
		
		cBox_OtherOption.setVisible(false);
		txtF_Search.setVisible(false);
		HBox_FirstDateContainer.setVisible(false);
		HBox_SecondDateContainer.setVisible(false);
		btnSearch.setVisible(false);
		listView_Contacts.setVisible(true);

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
	
	private void setVisual_OtherOption() {
		txtF_Search.setVisible(false);
		HBox_FirstDateContainer.setVisible(false);
		HBox_SecondDateContainer.setVisible(false);
		listView_Contacts.setVisible(true);

		txtF_Search.setMaxHeight(0);
		HBox_FirstDateContainer.setMaxHeight(0);
		HBox_SecondDateContainer.setMaxHeight(0);
		listView_Contacts.setMaxHeight(0);

		row_txtF_Search.setMaxHeight(0);
		row_HBox_FirstDateContainer.setMaxHeight(0);
		row_HBox_SecondDateContainer.setMaxHeight(0);
		row_listView_Contacts.setMaxHeight(0);
	}
}