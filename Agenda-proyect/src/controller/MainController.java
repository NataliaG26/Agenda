package controller;

import javafx.fxml.FXMLLoader;
import model.Agenda;

public class MainController {
	
	private Agenda agenda;
	
	public MainController() throws Exception {
		agenda = new Agenda();
		
	}
	
	 public void conection(FXMLLoader fxml, String controller) {
		 	if(controller.equals("Agenda")) {
				AgendaController obj = fxml.getController();
				obj.setMainController(this);
			}else if(controller.equals("Contact")) {
				ContactController obj = fxml.getController();
				obj.setMainController(this);
			}else if(controller.equals("Summary")) {
				SummaryController obj = fxml.getController();
				obj.setMainController(this);
			}
			
		}
	

}
