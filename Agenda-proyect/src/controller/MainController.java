package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import model.Agenda;

/**
 * This class manage the necessary attributtes and methods to launch the user interface.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class MainController {

	private Agenda agenda;

	public final static double ICONE_SIZE = 32;
	public final static String ID_AGENDA = "Agenda";
	public final static String ID_SUMMARY = "Summary";
	public final static String ID_CONTACTS = "Contacts";

	/**
	 * <b>MainController Constructor</b>
	 * creates a new agenda object to manage the required information contained on itself.
	 */
	public MainController() {
		agenda = new Agenda();

	}

	/**
	 * This method returns the size of the visible list for the user, after executing the requested filter.
	 * @return the size of the list.
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
	 * retorna la fecha de cumpelaños del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
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
	 * retorna la fecha de cumpelaños del contacto en la posicion i de la lista que sera visible al usuario, despues de realizar el filtro solicitado
	 */
	public String getContactEnrolledCreditsNumber(int i) {
		return agenda.getContactsView().get(i).getEnrolledCredits()+"";
	}

	/*
	 * retorna el tamaño de la lista de subjects del contacto representado por contact
	 */
	public int getSizeSubjectsContact(int contact) {
		return agenda.getContactsView().get(contact).getMySubjects().size();
	}

	/*
	 * retorna el nombre de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectNameContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjectsList().get(subject).getName();
	}

	/*
	 * retorna el numero de creditos de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectCreditsContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjectsList().get(subject).getNumberCredits()+"";
	}

	/*
	 * retorna el departamento de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 *
	public String getSubjectDepContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getMySubjects().get(subject).
	}

	 */

	public List<String> getContactsName(){
		return new ArrayList<String>();
	}

	/**
	 * return a list with option searching
	 */
	public List<String> getSearchOptions(){
		List<String> searchOptions = new ArrayList<String>();
		searchOptions.add(Agenda.SEARCH_NAME);
		searchOptions.add(Agenda.SEARCH_AGE);
		searchOptions.add(Agenda.SEARCH_BIRTHDAY);
		searchOptions.add(Agenda.SEARCH_SUBJECT);
		return searchOptions;
	}

	/**
	 * return a list with order options
	 */
	public List<String> getOrderOptions(){
		List<String> searchOptions = new ArrayList<String>();
		searchOptions.add(Agenda.ORDER_NAME);
		searchOptions.add(Agenda.ORDER_AGE);
		searchOptions.add(Agenda.ORDER_BIRTHDAY);
		return searchOptions;
	}
	
	/**
	 * return a list with birthday option searching
	 */
	public List<String> getSearchBirthdayOptions(){
		List<String> searchOptions = new ArrayList<String>();
		searchOptions.add(Agenda.FILTER_BIRTHDAY);
		searchOptions.add(Agenda.FILTER_BIRTHDAY_BETWEEN_DATES);
		searchOptions.add(Agenda.FILTER_BIRTHDAY_BETWEEN_MONTHS);
		searchOptions.add(Agenda.FILTER_BIRTHDAY_MONTHS);
		return searchOptions;
	}
	
	/**
	 * return a list with order options
	 */
	public List<String> getSearchAgeOptions(){
		List<String> searchOptions = new ArrayList<String>();
		searchOptions.add(Agenda.FILTER_AGE);
		searchOptions.add(Agenda.FILTER_AGE_JOUNGER);
		searchOptions.add(Agenda.FILTER_AGE_OLDER);
		return searchOptions;
	}
	
	/**
	 * return a list with birthday option searching
	 */
	public List<String> getSearchSubjectOptions(){
		List<String> subjectOptions = new ArrayList<String>();
		for (int i = 0; i < agenda.getSubjectView().size(); i++) {
			subjectOptions.add(agenda.getSubjectView().get(i).getName());
		}
		return subjectOptions;
	}
	
	public void addSubject(int contact, String nameSubject) {
		agenda.addSubject(nameSubject, agenda.getContactsView().get(contact).getId());
	}
	
	public void newSubject(String subjectName, int credits) {//**********************
		//nueva materia, parametros 
		
	}

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
