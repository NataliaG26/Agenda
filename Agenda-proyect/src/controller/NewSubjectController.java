package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewSubjectController implements Initializable{
	

	ContactController contact;
	
    @FXML
    private TextField txtF_Name;

    @FXML
    private TextField txtF_Credits;

    @FXML
    void cancel(MouseEvent event) {

    }

    @FXML
    void check(MouseEvent event) {
    	contact.newSubject(txtF_Name.getText(), txtF_Credits.getText());
    }
    public void setContact(ContactController contactC) {
    	contact = contactC;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
