package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Agenda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class manage the necessary attributtes and methods to launch the user interface.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class ContactController implements Initializable{

	@FXML
	private ImageView image_EditContact;

	@FXML
	private ImageView image_CancelEditContact;

	@FXML
	private ImageView image_deleteContact;

	@FXML
	private ImageView image_CheckEditContact;

	@FXML
	private ImageView image_Contact;

	@FXML
	private TextField txtF_Name;

	@FXML
	private TextField txtF_LastName;

	@FXML
	private TextField txtF_PhoneNumber;

	@FXML
	private TextField txtF_Email;

	@FXML
	private TextField txtF_age;

	@FXML
	private TextField txtF_Carrera;

	@FXML
	private TextField txtF_id;

	@FXML
	private TextField txtF_DayBirthday;

	@FXML
	private ComboBox<String> cBox_MonthBirthday;

	@FXML
	private ImageView image_BackToContact;

	@FXML
	private ImageView image_nextContact;

	@FXML
	private ListView<String> listView_ContactSubject;

	@FXML
	private Label label_TotalCredits;

	@FXML
	private TextField txtF_SubjectName;

	@FXML
	private ImageView image_EditSubject;

	@FXML
	private ImageView image_CancelEditSubject;

	@FXML
	private ImageView image_DeleteSubject;

	@FXML
	private ImageView image_CheckEditSubject;

	@FXML
	private TextField txtF_CredistSubject;

	@FXML
	private TextField txtF_SubjectDep;
	
	@FXML
	private Label label_Dep;

	private MainController mainController;

	//represents the current contact on visibility (is an integer that represents the position of the visible list)
	private int contact;

	//represents the curren subject on visibility (is an integer that represents the position of the visible list)
	private int subject;

	@Override
	/**
	 * This method initializes the current controller for the current stage.
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
		contact = 0;
		mainController = null;
	}
	
	/**
	 * change the object mainController for to do the conection with the main controller class
	 * @param mainController
	 */
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
		subject = 0;
		contact =0;
	}
	
	/**
	 * shows the contact´s information in contacts window
	 */
	private void showContact() {
		//conectar modelo, lista con la info de los contactos
		//info por parametro correo, codigo, edad, cumplaños, carrera, creditos, avatar, materias,
		txtF_Name.setText(mainController.getContactName(contact));
		txtF_PhoneNumber.setText(mainController.getContactPhonenumber(contact));
		txtF_Email.setText(mainController.getContactEmail(contact));
		txtF_id.setText(mainController.getContactId(contact));
		txtF_age.setText(mainController.getContactAge(contact));
		String[] birthday = mainController.getContactBirthday(contact).split("/");
		txtF_DayBirthday.setText(birthday[0]);
		cBox_MonthBirthday.setPromptText(birthday[1]);
		cBox_MonthBirthday.setEditable(false);
		txtF_Carrera.setEditable(false);
		label_TotalCredits.setText(mainController.getContactEnrolledCreditsNumber(contact));
		String url = mainController.getContactAvatar(contact);
		if(!url.contains(" ")) {
			image_Contact.setImage(new Image(url));
		}
		else {
			image_Contact.setImage(new Image("https://www.orthopaedix.de/sites/default/files/2019-12/person.png"));
		}
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSubjectsNameContact(contact));
		listView_ContactSubject.setItems(list);
		
	}
	
	@FXML
	/**
	 * This method adds a new subject into the current student subject list.
	 * <b>Pos:</b> the subject is added to the subject list.
	 * @param event the event triggered by the user.
	 */
	void addContactSubject(MouseEvent event) {
		//nueva pantalla para seleccionar la materi que quiere agregar al contacto
		//relacionar maeteria con el contacto / model
		//contacto con la materia /model
		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ui\\AddSubject.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Agregar materia");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AddSubjectController addSubject = loader.getController();
		addSubject.setContact(this);
		addSubject.loadCBox(mainController.getSearchSubjectOptions());
	}
	
	public void addSubject(String subject) {
		mainController.addSubject(contact, subject);
		setVisual_ListViewSubject();
	}
	
	public void newSubject() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ui\\NewSubject.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Nueva materia");
			Image image = new Image("https://image.flaticon.com/icons/png/512/116/116345.png");
			stage.getIcons().add(image);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NewSubjectController newSubject = loader.getController();
		newSubject.setContact(this);
	}
	
	public void newSubject(String name, String credits) {
		int c= Integer.parseInt(credits);
		mainController.newSubject(name, c);
	}
	
	@FXML
	/**
	 * This method allows to return for an specific view of an specific contact to a general view of all contacts
	 * @param event the event triggered by the user.
	 */
	public void backToContact(MouseEvent event) {
		//lista con la info de los contactos que va a mostrar
		//showContact(info del contact actual/anterior);
		if(contact-1<0) {
			contact = mainController.getSizeContactsView()-1;
		}else {
			contact--;
		}
		showContact();
		setVisual_ShowSubjectNotSelected();
	}

	@FXML
	/**
	 * This method cancels the current edition of a contact.
	 * <b>Pos:</b> the edition is cancelled.
	 * @param event the event triggered by the user.
	 */
	void cancelEditContact(MouseEvent event) {
		setVisual_ShowContact();
		//showSubject();
		//con el contacto actual
		//no hacer ningun cambio
	}

	@FXML
	/**
	 * This method cancels the current edition of a subject.
	 * <b>Pos:</b> the edition is cancelled.
	 * @param event the event triggered by the user.
	 */
	void cancelEditSubject(MouseEvent event) {
		setVisual_ShowSubjectSelected();
		//con el contacto actual
		//no hacer ningun cambio
	}

	@FXML
	/**
	 * This method updates the information of the contact when edited.
	 * <b>Pos:</b> the information of the contact is updated.
	 * @param event the event triggered by the user.
	 */
	void checkEditContact(MouseEvent event) {
		//tomar la info de los txtF y cBox, para actualizar la info del contact
		//mostrar contacto
		setVisual_ShowContact();
		showContact();
	}

	@FXML
	/**
	 * This method updates the information of the contact when edited.
	 * <b>Pos:</b> the information of the contact is updated.
	 * @param event the event triggered by the user.
	 */
	void checkEditSubject(MouseEvent event) {
		//tomar la info de los txtF y actualizar la info de la materia
		//mostar materia
		setVisual_ShowSubjectSelected();
		showSubject();
		
	}

	@FXML
	/**
	 * This method deletes a contact from the agenda.
	 * </b>Pos:</b> the contact is deleted.
	 * @param event the event triggered by the user.
	 */
	void deleteContact(MouseEvent event) {//*******************************
		//mensaje de confirmacion
		//si: borrar contacto seleccionado
		//no: no hacer nada
	}
	

	@FXML
	/**
	 * This method removes a subject from the current contact subject's list.
	 * <b>Pos:</b> the subject is removed.
	 * @param event the event triggered by the user.
	 */
	void removeSubjectContact(MouseEvent event) {//*********************************
		//mensaje de confirmacion
		//si: borrar relacion del contacto con la materia selecionada
		//no: no hacer nada
	}

	@FXML
	/**
	 * This method shows the edition scene of a contact on screen.
	 * @param event the event triggered by the user.
	 */
	void editContact(MouseEvent event) {
		setVisual_EditContact();
	}

	@FXML
	/**
	 * This method shows the edition scene of the subject on screen.
	 * @param event the event triggered by the user.
	 */
	void editSubject(MouseEvent event) {
		setVisual_EditSubject();
	}

	@FXML
	/**
	 * This method allows to move forward through the contacts entries. 
	 * @param event the event triggered by the user.
	 */
	void nextContact(MouseEvent event) {
		//lista con la info de los contactos que va a mostrar
		//showContact(info del contact actual/siguiente);
		if(contact+1>mainController.getSizeContactsView()-1) {
			contact = 0;
		}else {
			contact++;
		}
		showContact();
		setVisual_ShowSubjectNotSelected();
	}


	//cambia la vista de la ventana para el estado de agregar contacto
	public void setVisualNewContact() {
		setVisual_EditContact();
		
		
		//create a contact conect with model

	}

	/**
	 * This method shows the subject scene on screen with the information of the subject
	 */
	private void showSubject() {
		//modificar info subject
    	txtF_SubjectName.setText(mainController.getSubjectNameContact(contact, subject));
    	txtF_CredistSubject.setText(mainController.getSubjectNameContact(contact, subject));
	}
	
	private void loadCBoxMonths() {
		ObservableList<String> list = FXCollections.observableArrayList(Agenda.MONTHS);
		cBox_MonthBirthday.setItems(list);
	}
	
	/**
	 * change the contact window view for to edit subject, able editing, and shows only the options that are allowed
	 */
	public void setVisual_EditSubject() {

		image_CancelEditSubject.setVisible(true);
		image_CheckEditSubject.setVisible(true);

		image_CancelEditSubject.setFitWidth(MainController.ICONE_SIZE);
		image_CheckEditSubject.setFitWidth(MainController.ICONE_SIZE);

		image_DeleteSubject.setVisible(false);
		image_EditSubject.setVisible(false);

		image_DeleteSubject.setFitWidth(0);
		image_EditSubject.setFitWidth(0);

		txtF_CredistSubject.setEditable(true);
		txtF_SubjectName.setEditable(true);
	}

	/**
	 * change the contact window view for to edit contact, able editing, and shows only the options that are allowed
	 */
	public void setVisual_EditContact() {

		image_CancelEditContact.setVisible(true);
		image_CheckEditContact.setVisible(true);

		image_CancelEditContact.setFitWidth(MainController.ICONE_SIZE);
		image_CheckEditContact.setFitWidth(MainController.ICONE_SIZE);

		image_EditContact.setVisible(false);
		image_deleteContact.setVisible(false);

		image_EditContact.setFitWidth(0);
		image_deleteContact.setFitWidth(0);

		image_nextContact.setVisible(false);
		image_BackToContact.setVisible(false);

		image_BackToContact.setFitWidth(0);
		image_BackToContact.setFitWidth(0);

		txtF_Name.setEditable(true);
		txtF_LastName.setEditable(true);
		txtF_PhoneNumber.setEditable(true);
		txtF_Email.setEditable(true);
		txtF_id.setEditable(true);
		txtF_age.setEditable(true);
		txtF_DayBirthday.setEditable(true);
		cBox_MonthBirthday.setEditable(true);
		txtF_Carrera.setEditable(true);
		
		loadCBoxMonths();
	}

	/**
	 * change the contact window view for show the contact when subject has been selected, disable editing, and shows only the options that are allowed
	 */
	public void setVisual_ShowSubjectSelected() {
		image_CancelEditSubject.setVisible(false);
		image_CheckEditSubject.setVisible(false);

		image_CancelEditSubject.setFitWidth(0);
		image_CheckEditSubject.setFitWidth(0);

		image_EditSubject.setVisible(true);
		image_DeleteSubject.setVisible(true);

		image_EditSubject.setFitWidth(MainController.ICONE_SIZE);
		image_DeleteSubject.setFitWidth(MainController.ICONE_SIZE);

		txtF_CredistSubject.setEditable(false);
		txtF_SubjectDep.setEditable(false);
		txtF_SubjectName.setEditable(false);
	}

	/**
	 * change the contact window view for show the contact when no subject has been selected, disable editing, and shows only the options that are allowed
	 */
	public void setVisual_ShowSubjectNotSelected() {
		image_CancelEditSubject.setVisible(false);
		image_CheckEditSubject.setVisible(false);

		image_CancelEditSubject.setFitWidth(0);
		image_CheckEditSubject.setFitWidth(0);

		image_EditSubject.setVisible(false);
		image_DeleteSubject.setVisible(false);

		image_EditSubject.setFitWidth(0);
		image_DeleteSubject.setFitWidth(0);

		txtF_CredistSubject.setEditable(false);
		txtF_SubjectDep.setEditable(false);
		txtF_SubjectName.setEditable(false);
		
	}
	
	public void setVisual_ListViewSubject() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getSubjectsNameContact(contact));
		listView_ContactSubject.setItems(list);
	}

	/**
	 * change the contact window view for show the contact, disable editing, and shows only the options that are allowed
	 */
	public void setVisual_ShowContact() {

		image_CancelEditContact.setVisible(false);
		image_CheckEditContact.setVisible(false);

		image_CancelEditContact.setFitWidth(0);
		image_CheckEditContact.setFitWidth(0);

		image_EditContact.setVisible(true);
		image_deleteContact.setVisible(true);

		image_EditContact.setFitWidth(MainController.ICONE_SIZE);
		image_deleteContact.setFitWidth(MainController.ICONE_SIZE);
		
		image_BackToContact.setVisible(true);
		image_BackToContact.setFitWidth(MainController.ICONE_SIZE);
		image_nextContact.setVisible(true);
		image_nextContact.setFitWidth(MainController.ICONE_SIZE);

		txtF_Name.setEditable(false);
		txtF_LastName.setEditable(false);
		txtF_PhoneNumber.setEditable(false);
		txtF_Email.setEditable(false);
		txtF_id.setEditable(false);
		txtF_age.setEditable(false);
		txtF_DayBirthday.setEditable(false);
		cBox_MonthBirthday.setEditable(false);
		txtF_Carrera.setEditable(false);
		showContact();
	}
}