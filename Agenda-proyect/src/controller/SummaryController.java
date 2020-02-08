package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;

public class SummaryController implements Initializable{

	@FXML
    private Label labelSubjectsForStudent;

    @FXML
    private Label labelCreditsForStudent;

    @FXML
    private ListView<?> listView_Subject;

    @FXML
    private Label label_LessEnrolledSubject;

    @FXML
    private Label label_Subject;

    @FXML
    void addSubject(MouseEvent event) {
    	System.out.println("add");
    }

    @FXML
    void delateSubject(MouseEvent event) {

    }

    @FXML
    void editSubject(MouseEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
