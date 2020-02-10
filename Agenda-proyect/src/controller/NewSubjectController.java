package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewSubjectController implements Initializable{
	
	ContactController contact;
	
    @FXML
    private TextField txtF_Name;

    @FXML
    private TextField txtF_Credits;
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    @FXML
    void cancel(MouseEvent event) {
    	Stage stage = (Stage) txtF_Name.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void check(MouseEvent event) {
    	contact.newSubject(txtF_Name.getText(), txtF_Credits.getText());
    	Stage stage = (Stage) txtF_Name.getScene().getWindow();
    	stage.close();
    }
    public void setContact(ContactController contactC) {
    	contact = contactC;
    }
}