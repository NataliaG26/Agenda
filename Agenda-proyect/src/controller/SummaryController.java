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

/**
 * This class manage the necessary attributtes and methods to launch the user interface.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
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
	private TextField txtF_SubjectName;

	@FXML
	private TextField txtF_CredistSubject;

	@FXML
	private TextField txtF_SubjectDep;

	@FXML
	private Label label_StudentsEnrolledSubject;
	
	@FXML
	private Label label_Dep;

	private MainController main;
	
	private int subject;

	@Override
	/**
	 * This method initializes the current controller for the current stage.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		HBox_imagesOptionsSubjects.setVisible(false);
	}
	
	@FXML
	/**
	 * this method adds a subject into the agenda through the gui.
	 * <b>Pre:</b> The agenda exists.
	 * <b>Pos:</b> the subject is added.
	 * @param event the event triggered by the user.
	 */
	void addSubject(MouseEvent event) {
		System.out.println("add");
	}

	@FXML
	/**
	 * This method cancels the edition of a subject through the gui.
	 * <b>Pos:</b> the subject edition is cancelled.
	 * @param event the event triggered by the user.
	 */
	void cancelEditSubject(MouseEvent event) {

	}

	@FXML
	/**
	 * This method confirms that a subject is going to be edited.
	 * @param event the event triggered by the user.
	 */
	void checkEditSubject(MouseEvent event) {

	}

	@FXML
	/**
	 * This method removes a subject from a contact.
	 * <b>Pos:</b> the subject is removed.
	 * @param event the event triggered by the user.
	 */
	void removeSubject(MouseEvent event) {

	}

	@FXML
	/**
	 * This method confirms the edition of a subject.
	 * <b>Pos:</b> the subject is edited.
	 * @param event the event triggered by the user.
	 */
	void editSubject(MouseEvent event) {

	}
	
	@FXML
    void delateSubject(MouseEvent event) {
		
    }
	
	private void showSubject() {
		//pedir info
	}
	
	private void setVisual_EditSubject() {
		txtF_CredistSubject.setEditable(false);
		txtF_SubjectName.setEditable(false);
		
		txtF_SubjectDep.setEditable(false);
		txtF_SubjectDep.setVisible(false);
	}
	
	private void setVisual_ShowSubject() {
		txtF_CredistSubject.setEditable(false);
		txtF_SubjectName.setEditable(false);
		
		txtF_SubjectDep.setEditable(false);
		txtF_SubjectDep.setVisible(false);
	}
	
	public void setVisual_ShowSummary() {
		
		setVisual_ShowSubject();
		
	}

	/**
	 * this method sets the main controller.
	 * <b>Pre:</b> the maincontroller is not null.
	 * @param mainController the maincontroller.
	 */
	public void setMainController(MainController mainController) {
		this.main = mainController;
	}

}