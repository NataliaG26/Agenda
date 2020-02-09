package controller;

import javafx.fxml.FXMLLoader;
import model.Agenda;

public class MainController {
	
	private Agenda agenda;

	public final static double ICONE_SIZE = 32;
	public final static String ID_AGENDA = "Agenda";
	public final static String ID_SUMMARY = "Summary";
	public final static String ID_CONTACTS = "Contacts";
	
	public MainController() {
		agenda = new Agenda();
		
	}
	
	/*
	 * retorna el tama�o de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public int getSizeContactsView() {
		return agenda.getContactsView().size();
	}
	
	/*
	 * retorna el nombre del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactName(int i) {
		return agenda.getContactsView().get(i).getName();
	}
	
	/*
	 * retorna el numero de telfono del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactPhonenumber(int i) {
		return agenda.getContactsView().get(i).getPhonenumber();
	}
	
	
	/*
	 * retorna el correo del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactEmail(int i) {
		return agenda.getContactsView().get(i).getEmail();
	}
	
	/*
	 * retorna el codigo del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactId(int i) {
		return agenda.getContactsView().get(i).getId();
	}
	
	/*
	 * retorna la edad del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactAge(int i) {
		return agenda.getContactsView().get(i).getAge()+"";
	}
	
	/*
	 * retorna la fecha de cumpela�os del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactBirthday(int i) {
		return agenda.getContactsView().get(i).toStringDateOfBirth();
	}
	
	/*
	 * retorna la carrera del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 *
	public String getContactCarrera(int i) {
		return agenda.getContacts().get(i).getCarrera();
	}*/
	
	/*
	 * retorna la fecha de cumpela�os del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactEnrolledCreditsNumber(int i) {
		return agenda.getContactsView().get(i).getEnrolledCredits()+"";
	}
	
	/*
	 * retorna el tama�o de la lista de subjects del contacto representado por contact
	 */
	public int getSizeSubjectsContact(int contact) {
		return agenda.getContactsView().get(contact).getMySubjects().size();
	}
	
	/*
	 * retorna el nombre de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectNameContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjects().get(subject).getName();
	}
	
	/*
	 * retorna el numero de creditos de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectNameContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjects().get(subject).getNumberCredits()+"";
	}
	
	/*
	 * retorna el departamento de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectDepContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjects().get(subject).
	}
	
	*/
	
	/*
	 * 
	 */
	 public void conection(FXMLLoader fxml, String controller) {
		 	if(controller.equals(ID_AGENDA)) {
				AgendaController obj = fxml.getController();
				obj.setMainController(this);
			}else if(controller.equals(ID_CONTACTS)) {
				ContactController obj = fxml.getController();
				obj.setMainController(this);
			}else if(controller.equals(ID_SUMMARY)) {
				SummaryController obj = fxml.getController();
				obj.setMainController(this);
			}
			
		}
	

}
