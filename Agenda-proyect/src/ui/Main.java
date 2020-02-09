package ui;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class manage the necessary attributes and methods to launch the constructor method for the whole program.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class Main extends Application{

	private MainController main;

	/**
	 * <b>Main method</b>
	 * @param args 
	 */
	public static void main(String args[]) {
		launch();
	}

	/**
	 * This method launches the main scene of the graphical user interface
	 * @param stage the stage that controls this scene
	 */
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Agenda.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setTitle("Lazy Agenda - it's never been so easy");
		Image image = new Image("https://cdn.onlinewebfonts.com/svg/img_500827.png");
		stage.getIcons().add(image);
		stage.setScene(scene);
		stage.show();
		main = new MainController();
		main.conection(loader, "Agenda");
	}
}
