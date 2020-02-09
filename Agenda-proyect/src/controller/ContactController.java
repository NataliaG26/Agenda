package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
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
    private TextField txtF_Birthday;

    @FXML
    private TextField txtF_Semester;

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
    
    private MainController main;
    

    @FXML
    void addContactSubject(MouseEvent event) {

    }

    @FXML
    void backToConact(MouseEvent event) {

    }

    @FXML
    void cancelEditContact(MouseEvent event) {

    }

    @FXML
    void cancelEditSubject(MouseEvent event) {

    }

    @FXML
    void checkEditContact(MouseEvent event) {

    }

    @FXML
    void checkEditSubject(MouseEvent event) {

    }

    @FXML
    void delateContact(MouseEvent event) {

    }

    @FXML
    void delateSubjectContact(MouseEvent event) {

    }

    @FXML
    void editContact(MouseEvent event) {

    }

    @FXML
    void editSubject(MouseEvent event) {

    }

    @FXML
    void nextContact(MouseEvent event) {

    }
    
    //cambia la vista de la ventana para el estado de agregar contacto
    public void setVisualNewContact() {
    	image_EditContact.setVisible(false);
    	image_deleteContact.setVisible(false);
    	image_CancelEditSubject.setVisible(false);
    	image_CheckEditSubject.setVisible(false);
    }
    
    //cambia la vista de la ventana para el esatdo de mostrar contacto
    public void setVisualShowContact() {
    	
    }
    
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//cambia el objeto main controller para realizar la coneccion con la clase controladora principal de
    public void setMainController(MainController mainController) {
		this.main = mainController;
	}

}
