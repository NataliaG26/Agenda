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

public class AddSubjectController implements Initializable{
	
	ContactController contact;
	
	@FXML
    private ComboBox<String> cBox_Subject;

    @FXML
    private ImageView image_Cancel;

    @FXML
    private ImageView image_Check;

    @FXML
    void cancel(MouseEvent event) {
    	
    }

    @FXML
    void check(MouseEvent event) {
    	String value = cBox_Subject.getValue();
    	if(value.equals("Nueva materia")) {
    		contact.newSubject();
    	}else {
    		contact.addSubject(value);
    	}
    	
    }
    
    public void setContact(ContactController contactC) {
    	contact = contactC;
    }

    public void loadCBox(List<String> subjects) {
    	subjects.add("Nueva materia");
    	ObservableList<String> list = FXCollections.observableArrayList(subjects);
		cBox_Subject.setItems(list);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
