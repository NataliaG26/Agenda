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
}