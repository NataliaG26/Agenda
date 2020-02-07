package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String args[]) {
		launch();
	}
	
	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Agenda.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		scene.getStylesheets().add(Main.class.getResource("../CSS/light-theme.css").toExternalForm());
		stage.setTitle("Agenda");
		stage.setScene(scene);
		stage.show();
	}

}
