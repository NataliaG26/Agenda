package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
	
	public static void main(String args[]) {
		
	}
	
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Agenda.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Agenda");
		stage.setScene(scene);;
		stage.show();
	}

}
