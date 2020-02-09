package ui;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private MainController main;
	
	public static void main(String args[]) {
		launch();
	}
	
	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Agenda.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setTitle("Agenda");
		stage.setScene(scene);
		stage.show();
		main = new MainController();
		main.conection(loader, "Agenda");
	}

}
