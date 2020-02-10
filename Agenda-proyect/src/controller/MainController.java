package controller;

import java.time.LocalDate;
import java.time.Month;
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
		agenda.addSubject("Liderazgo", "A00355727");
		agenda.addSubject("Cálculo de varias variables", "A00355727");
		agenda.writeContacts();
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

	/**
	 * Returns the avatar of the contact in the position i from the visible list for the user
	 * @param i the position of the contact
	 * @return the avatar of the contact
	 */
	public String getContactAvatar(int i) {
		return agenda.getContactsView().get(i).getAvatar();
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
	 */
	public String getSubjectNameContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getListOfSubjects().get(subject).getName();
	}

	/*
	 * retorna el numero de creditos de la materia en la posicion subject de la lista de las materias del contacto en la posicion contact de la lista contactsView
	 */
	public String getSubjectCreditsContact(int contact, int subject) {
		return agenda.getContactsView().get(contact).getListOfSubjects().get(subject).getNumberCredits()+"";
	}


	public List<String> getContactsName(){
		return agenda.getContactsName();
	}

	public List<String> getSubjectsName(){
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < agenda.getSubjectView().size(); i++) {
			names.add(agenda.getSubjectView().get(i).getName());
		}
		return names;
	}

	public List<String> getSubjectsNameContact(int contact){
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < agenda.getContactsView().get(contact).getListOfSubjects().size(); i++) {
			names.add(agenda.getContactsView().get(contact).getListOfSubjects().get(i).getName());
		}
		return names;
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
	 * return a list with subjects
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

	/**
	 * This method allows to connect between the different controllers and fxml files.
	 * <b>Pre:</b> the fxmlloader exists.
	 * <b>Pos:</b> the connection is loaded when requested.
	 * @param fxml the responsible for loading the connection.
	 * @param controller the responsible for manage the connection.  
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
	
	public void masterSort(String sorter) {
		
		agenda.sort(sorter);
		
	}
	
	public void masterSearch(String filter, String secondOption, String age, int day1, String month1, int day2, String month2) {

		switch (filter) {

		case Agenda.SEARCH_NAME:

			agenda.searchByName(secondOption);

			break;

		case Agenda.SEARCH_BIRTHDAY:

			if (secondOption.equals(Agenda.FILTER_BIRTHDAY)) {
				int mes1 = convertMonth(month1);
				agenda.searchByDateOfBirth(day1, mes1, -1, -1, 0);

			}else if (secondOption.equals(Agenda.FILTER_BIRTHDAY_BETWEEN_DATES)) {
				int mes1 = convertMonth(month1);
				int mes2 = convertMonth(month2);
				agenda.searchByDateOfBirth(day1, mes1, day2, mes2, 3);

			}else if (secondOption.equals(Agenda.FILTER_BIRTHDAY_BETWEEN_MONTHS)) {
				int mes1 = convertMonth(month1);
				int mes2 = convertMonth(month2);
				agenda.searchByDateOfBirth(-1, mes1, -1, mes2, 2);

			}else if(secondOption.equals(Agenda.FILTER_BIRTHDAY_MONTHS)) {
				int mes1 = convertMonth(month1);
				agenda.searchByDateOfBirth(-1, mes1, -1, -1, 1);

			}

			break;

		case Agenda.SEARCH_AGE:

			int edad = Integer.valueOf(age);

			if (secondOption.equals(Agenda.FILTER_AGE)) {

				agenda.searchByAge(edad, 0);

			}else if (secondOption.equals(Agenda.FILTER_AGE_JOUNGER)) {

				agenda.searchByAge(edad, 1);

			}else if (secondOption.equals(Agenda.FILTER_AGE_OLDER)) {

				agenda.searchByAge(edad, 2);

			}

			break;

		default:
			break;
		}

	}

	private int convertMonth(String month) {
		
		int salida;
		switch (month) {

		case "Enero":
			salida = 1;
			break;

		case "Febrero":
			salida = 2;
			break;

		case "Marzo":
			salida = 3;
			break;

		case "Abril":
			salida = 4;
			break;

		case "Mayo":
			salida = 5;
			break;

		case "Junio":
			salida = 6;
			break;

		case "Julio":
			salida = 7;
			break;

		case "Agosto":
			salida = 8;
			break;

		case "Septiembre":
			salida = 9;
			break;

		case "Octubre":
			salida = 10;
			break;

		case "Noviembre":
			salida = 11;
			break;
			
		case "Diciembre":
			salida = 12;
			break;

		default:
			salida = 1;
			break;
		}
		
		return salida;

	}
}














