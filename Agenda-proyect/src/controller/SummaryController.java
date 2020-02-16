package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
	private ImageView image_AddSubject;

	@FXML
	private ListView<String> listView_Subject;

	@FXML
	private Label label_MoreEnrolledSubject;

	@FXML
	private Label label_LessEnrolledSubject;

	@FXML
	private Label label_StudentsEnrolledSubject;

	@FXML
	private TextField txtF_SubjectDep;
	 
    @FXML
    private TextField txtF_SubjectName;

    @FXML
    private ImageView image_DeleteSubject;

    @FXML
    private TextField txtF_CredistSubject;

    @FXML
    private Label label_Dep;

    @FXML
    private TextField txtF_SubjectDep1;

	private MainController main;

	private int subject;

	@Override
	/**
	 * This method initializes the current controller for the current stage.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		main = new MainController();
		showSubject();
		label_MoreEnrolledSubject.setText(label_MoreEnrolledSubject.getText() + main.moreEnrolledSubject().getName());
		label_LessEnrolledSubject.setText(label_LessEnrolledSubject.getText() + main.lessEnrolledSubject().getName());
	}

	/**
	 * this method sets the main controller.
	 * <b>Pre:</b> the maincontroller is not null.
	 * @param mainController the maincontroller.
	 */
	public void setMainController(MainController mainController) {
		this.main = mainController;
	}

	@FXML
	void addNewSubject(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ui\\NewSubject.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Nueva materia");
			Image image = new Image("https://image.flaticon.com/icons/png/512/116/116345.png");
			stage.getIcons().add(image);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NewSubjectController newSubject = loader.getController();
	}

	private void showSubject() {
		main = new MainController();
		ObservableList<String> list = FXCollections.observableArrayList(main.getSubjectsName());
		listView_Subject.setItems(list);
	}
	
	 @FXML
	 private void subjectSelected(MouseEvent event) {
		System.out.println(listView_Subject.getSelectionModel().getSelectedItem());
		//metodo felipe
		//subject = mainController.getSubjectPos(listView_Subject.getSelectionModel().getSelectedItem());
	 }

		@FXML
		/**
		 * This method cancels the current edition of a subject.
		 * <b>Pos:</b> the edition is cancelled.
		 * @param event the event triggered by the user.
		 */
		void cancelEditSubject(MouseEvent event) {
			setVisual_ShowSubjectSelected();
			//con el contacto actual
			//no hacer ningun cambio
		}

	    @FXML
	    void removeSubject(MouseEvent event) {
	    	
	    }
	    
		/**
		 * change the contact window view for show the contact when subject has been selected, disable editing, and shows only the options that are allowed
		 */
		public void setVisual_ShowSubjectSelected() {
			image_DeleteSubject.setVisible(true);

			image_DeleteSubject.setFitWidth(MainController.ICONE_SIZE);

			txtF_CredistSubject.setEditable(false);
			txtF_SubjectDep.setEditable(false);
			txtF_SubjectName.setEditable(false);
		}
		
		/**
		 * change the contact window view for show the contact when no subject has been selected, disable editing, and shows only the options that are allowed
		 */
		public void setVisual_ShowSubjectNotSelected() {
			image_DeleteSubject.setVisible(false);
			image_DeleteSubject.setFitWidth(0);

			txtF_CredistSubject.setEditable(false);
			txtF_SubjectDep.setEditable(false);
			txtF_SubjectName.setEditable(false);

		}
}