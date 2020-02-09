package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    private ComboBox<?> cBox_MonthBirthday;

    @FXML
    private ImageView imagen_BackToContact;

    @FXML
    private ImageView image_nextContact;

    @FXML
    private ListView<?> listView_ContactSubject;

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
    
    private MainController mainController;
    
    private int contact;

    @FXML
    void addContactSubject(MouseEvent event) {
    	//nueva pantalla para seleccionar la materi que quiere agregar al contacto
    	//relacionar maeteria con el contacto / model
    	//contacto con la materia /model
    }

    @FXML
    void backToConact(MouseEvent event) {
    	//lista con la info de los contactos que va a mostrar
    	//showContact(info del contact actual/anterior);
    }

    @FXML
    void cancelEditContact(MouseEvent event) {
    	setVisual_ShowContact();
    	//con el contacto actual
    	//no hacer ningun cambio
    }

    @FXML
    void cancelEditSubject(MouseEvent event) {
    	setVisual_ShowSubject();
    	//con el contacto actual
    	//no hacer ningun cambio
    }

    @FXML
    void checkEditContact(MouseEvent event) {
    	//tomar la info de los txtF y cBox, para actualizar la info del contact
    }

    @FXML
    void checkEditSubject(MouseEvent event) {
    	//tomar la info de los txtF y actualizar la info de la materia
    }

    @FXML
    void delateContact(MouseEvent event) {
    	//mensaje de confirmacion
    	//si: borrar contacto seleccionado
    	//no: no hacer nada
    }

    @FXML
    void delateSubjectContact(MouseEvent event) {
    	//mensaje de confirmacion
    	//si: borrar relacion del contacto con la materia selecionada
    	//no: no hacer nada
    }

    @FXML
    void editContact(MouseEvent event) {
    	setVisual_EditContact();
    }

    @FXML
    void editSubject(MouseEvent event) {
    	setVisual_EditSubject();
    }

    @FXML
    void nextContact(MouseEvent event) {
    	//lista con la info de los contactos que va a mostrar
    	//showContact(info del contact actual/siguiente);
    }
    
  //cambia la vista de la ventana para el estado de agregar contacto
    public void setVisualNewContact() {
    	setVisual_EditContact();
    	//create a contact conect with model
    	
    }
    
    private void showContact() {
    	//conectar modelo, lista con la info de los contactos
    	//info por parametro correo, codigo, edad, cumplaños, carrera, creditos, avatar, materias,
    	txtF_Name.setText(mainController.getContactName(contact));
    	txtF_PhoneNumber.setText(mainController.getContactPhonenumber(contact));
    	txtF_Email.setText(mainController.getContactEmail(contact));
    	txtF_id.setText(mainController.getContactId(contact));
    	txtF_age.setText(mainController.getContactAge(contact));
    	String[] birthday = mainController.getContactBirthday(contact).split(" ");
    	txtF_DayBirthday.setText(birthday[0]);
    	cBox_MonthBirthday.setPromptText(birthday[1]);
    	//txtF_Carrera.setText(mainController.getContactCarrera(contact));
    	label_TotalCredits.setText(mainController.getContactEnrolledCreditsNumber(contact));
    	//image_Avatar.mainController.getContactId(contact));
    }
    
    //cambia la visibilidad de la ventana y habilita las secciones para editar informacion de la materia
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
    	txtF_SubjectDep.setEditable(true);
    	txtF_SubjectName.setEditable(true);
    }
    
    //cambia la visibilidad de la ventana y habilita las secciones para editar informacion de contacto
    public void setVisual_EditContact() {
    	
    	image_CancelEditSubject.setVisible(true);
    	image_CheckEditSubject.setVisible(true);
    	
    	image_EditContact.setFitWidth(MainController.ICONE_SIZE);
    	image_deleteContact.setFitWidth(MainController.ICONE_SIZE);
    	
    	image_EditContact.setVisible(false);
    	image_deleteContact.setVisible(false);
    	
    	image_EditContact.setFitWidth(0);
    	image_deleteContact.setFitWidth(0);
    	
    	txtF_Name.setEditable(true);
    	txtF_LastName.setEditable(true);
    	txtF_PhoneNumber.setEditable(true);
    	txtF_Email.setEditable(true);
    	txtF_id.setEditable(true);
    	txtF_age.setEditable(true);
    	txtF_DayBirthday.setEditable(true);
    	cBox_MonthBirthday.setEditable(true);
    	txtF_Carrera.setEditable(true);
    }
    
    public void setVisual_ShowSubject() {
    	image_CancelEditSubject.setVisible(false);
    	image_CheckEditSubject.setVisible(false);
    	
    	image_CancelEditSubject.setFitWidth(0);
    	image_CheckEditSubject.setFitWidth(0);
    	
    	txtF_CredistSubject.setEditable(false);
    	txtF_SubjectDep.setEditable(false);
    	txtF_SubjectName.setEditable(false);
    }

    //cambia la vista de la ventana para el esatdo de mostrar contacto
    public void setVisual_ShowContact() {
    	
    	txtF_Name.setEditable(false);
    	txtF_LastName.setEditable(false);
    	txtF_PhoneNumber.setEditable(false);
    	txtF_Email.setEditable(false);
    	txtF_id.setEditable(false);
    	txtF_age.setEditable(false);
    	txtF_DayBirthday.setEditable(false);
    	cBox_MonthBirthday.setEditable(false);
    	txtF_Carrera.setEditable(false);
    	
    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		contact = 0;
		mainController = null;
		
	}
	
	//cambia el objeto main controller para realizar la coneccion con la clase controladora principal de
    public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
