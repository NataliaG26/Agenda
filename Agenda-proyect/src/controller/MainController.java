package controller;

import javafx.fxml.FXMLLoader;
import model.Agenda;

public class MainController {
	
	private Agenda agenda;

	public final static double ICONE_SIZE = 32;
	
	public MainController() {
		agenda = new Agenda();
		
	}
	
	/*
	 * retorna el tamaño de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public int getSizeContactsView() {
		return agenda.getContactsView().size();
	}
	
	/*
	 * retorna el nombre del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactName(int i) {
		return agenda.getContacts().get(i).getName();
	}
	
	/*
	 * retorna el numero de telfono del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactPhonenumber(int i) {
		return agenda.getContacts().get(i).getPhonenumber();
	}
	
	
	/*
	 * retorna el correo del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactEmail(int i) {
		return agenda.getContacts().get(i).getEmail();
	}
	
	/*
	 * retorna el codigo del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactId(int i) {
		return agenda.getContacts().get(i).getId();
	}
	
	/*
	 * retorna la edad del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactAge(int i) {
		return agenda.getContacts().get(i).getAge()+"";
	}
	
	/*
	 * retorna la fecha de cumpelaños del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactBirthday(int i) {
		return agenda.getContacts().get(i).toStringDateOfBirth();
	}
	
	/*
	 * retorna la carrera del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 *
	public String getContactCarrera(int i) {
		return agenda.getContacts().get(i).getCarrera();
	}*/
	
	/*
	 * retorna la fecha de cumpelaños del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactEnrolledCreditsNumber(int i) {
		return agenda.getContacts().get(i).getEnrolledCredits()+"";
	}
	
	/*
	 * 
	 */
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
