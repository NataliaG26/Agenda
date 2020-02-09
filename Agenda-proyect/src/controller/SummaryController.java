package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.fxml.Initializable;

public class SummaryController implements Initializable{

	@FXML
    private Label labelSubjectsForStudent;

    @FXML
    private Label labelCreditsForStudent;

    @FXML
    private ListView<?> listView_Subject;
    
    @FXML
    private Label label_MoreEnrolledSubject;

    @FXML
    private Label label_LessEnrolledSubject;
    
    @FXML
    private HBox HBox_imagesOptionsSubjects;

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
    private Label label_StudentsEnrolledSubject;
    
    private MainController main;
    
    
    @FXML
    void addSubject(MouseEvent event) {
    	System.out.println("add");
    }

    @FXML
    void cancelEditSubject(MouseEvent event) {

    }

    @FXML
    void checkEditSubject(MouseEvent event) {

    }

    @FXML
    void delateSubject(MouseEvent event) {

    }

    @FXML
    void editSubject(MouseEvent event) {

    }
    
	
  //cambia el objeto main controller para realizar la coneccion con la clase controladora principal de
    public void setMainController(MainController mainController) {
		this.main = mainController;
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		HBox_imagesOptionsSubjects.setVisible(false);
		
	}
	
	

}
