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
    private ImageView image_BackToContact;

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
    
    //represnta el contacto que se esta visualizando
    //es un entero que es la posicion de la lista visible
    private int contact;
    
    //representa la materia del contacto que esta siendo visible 
    //es un entero que represnta la posicion de la materia en la lista de materias del contacto actual
    private int subject;

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
    	if(contact-1<0) {
    		contact = mainController.getSizeContactsView()-1;
    	}else {
    		contact--;
    	}
    	showContact();
    	setVisual_ShowSubjectNotSelected();
    }

    @FXML
    void cancelEditContact(MouseEvent event) {
    	setVisual_ShowContact();
    	showSubject();
    	//con el contacto actual
    	//no hacer ningun cambio
    }

    @FXML
    void cancelEditSubject(MouseEvent event) {
    	setVisual_ShowSubjectSelected();
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
    
    /*
     * muestra la informacion de la materia segun los atributos contact y subject 
     */
    private void showSubject() {
    	//modificar info subject
    	/*
    	txtF_SubjectName.setText(mainController.getSubjectNameContact(contact, subject));
    	txtF_CredistSubject.setText(mainController.getSubjectNameContact(contact, subject));
    	//txtF_SubjectDep.setText(mainController.getSubjectDepContact(contact, subject);
    	*/
    	
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
    	String[] birthday = mainController.getContactBirthday(contact).split(" ");
    	txtF_DayBirthday.setText(birthday[0]);
    	cBox_MonthBirthday.setPromptText(birthday[1]);
    	//txtF_Carrera.setText(mainController.getContactCarrera(contact));
    	label_TotalCredits.setText(mainController.getContactEnrolledCreditsNumber(contact));
    	//image_Avatar.mainController.getContactId(contact));
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
    	txtF_SubjectDep.setEditable(true);
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

    /**
     * change the contact window view for show the contact, disable editing, and shows only the options that are allowed
     */
    public void setVisual_ShowContact() {
    	
    	image_CancelEditContact.setVisible(false);
    	image_CheckEditContact.setVisible(false);
    	
    	image_CancelEditContact.setFitWidth(0);
    	image_CheckEditContact.setFitWidth(0);
    	
    	image_EditSubject.setVisible(true);
    	image_DeleteSubject.setVisible(true);
    	
    	image_EditSubject.setFitWidth(MainController.ICONE_SIZE);
    	image_DeleteSubject.setFitWidth(MainController.ICONE_SIZE);
    	
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
	
	/**
	 * change the object mainController for to do the conection with the main controller class
	 * @param mainController
	 */
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

}
