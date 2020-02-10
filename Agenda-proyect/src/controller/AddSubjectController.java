package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddSubjectController implements Initializable{
	
	ContactController contact;
	
	@FXML
    private ComboBox<String> cBox_Subject;

    @FXML
    private ImageView image_Cancel;

    @FXML
    private ImageView image_Check;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
	}
    
    @FXML
    public void cancel(MouseEvent event) {
    	Stage stage = (Stage) cBox_Subject.getScene().getWindow();
    	stage.close();
    }

    @FXML
    public void check(MouseEvent event) {
    	String value = cBox_Subject.getValue();
    	if(value.equals("Nueva materia")) {
    		contact.newSubject();
    	}else {
    		contact.addSubject(value);
    	}
    	Stage stage = (Stage) cBox_Subject.getScene().getWindow();
    	stage.close();
    }
    
    public void setContact(ContactController contactC) {
    	contact = contactC;
    }

    public void loadCBox(List<String> subjects) {
    	subjects.add("Nueva materia");
    	ObservableList<String> list = FXCollections.observableArrayList(subjects);
		cBox_Subject.setItems(list);
    }
}