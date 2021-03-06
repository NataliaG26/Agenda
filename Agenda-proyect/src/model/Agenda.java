package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class manage the necessary attributes and methods to create agendas.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan Jos� Valencia 
 * @version 1.0
 *
 */
public class Agenda {

	private Hashtable<String, Contact> contacts;
	private Hashtable<String, Subject> subjects;

	//contact's list visible for the user
	private List<Contact> contactsView;
	private List<Subject> subjectView; 

	private List<String> contactsName;

	//paths to read text files with information required
	public final static String PATH_SUBJECTS = "data/subjects.txt";
	public final static String PATH_STUDENTS = "data/students.txt";

	//Searching interests
	public final static String SEARCH_NAME = "Nombre";
	public final static String SEARCH_BIRTHDAY = "Cumplea�os";
	public final static String SEARCH_AGE = "Edad";
	public final static String SEARCH_SUBJECT = "Materia";

	//Date of birth searching criteria
	public final static String FILTER_BIRTHDAY = "Fecha exacta";
	public final static String FILTER_BIRTHDAY_BETWEEN_DATES = "Entre dos fechas";
	public final static String FILTER_BIRTHDAY_BETWEEN_MONTHS = "Entre dos meses";
	public final static String FILTER_BIRTHDAY_MONTHS = "Mes";

	//Age searching criteria
	public final static String FILTER_AGE = "Exacta";
	public final static String FILTER_AGE_OLDER = "Mayor que";
	public final static String FILTER_AGE_JOUNGER = "Menor que";

	//Sorting interests
	public final static String ORDER_NAME = "Por nombre A-Z";
	public final static String ORDER_BIRTHDAY = "Por fecha de cumplea�os";
	public final static String ORDER_AGE = "Por edad";

	//Months of the year
	public final static String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

	/**
	 * <b>Agenda Constructor</b>
	 * This method allows to build agendas.
	 */
	public Agenda() {

		contacts = new Hashtable<String, Contact>();
		subjects = new Hashtable<String, Subject>();
		
		readSubjects();
		readStudents();
		listOfContacts();
		listOfSubjects();
		
		//writeContacts();
	}

	/**
	 * This method returns the contacts list saved on this agenda.
	 * <b>Pre:</b> the agenda exists.
	 * @return the contacts list.
	 */
	public Hashtable<String, Contact> getContacts(){
		return contacts;
	}

	/**
	 * This method returns the available subjects list saved on this agenda.
	 * <b>Pre:</b> the agenda exists.
	 * @return the subjects list.
	 */
	public Hashtable<String, Subject> getSubjects(){
		return subjects;
	}

	/**
	 * This method returns the contacts list used for the visibility for the user.
	 * <b>Pre:</b> the agenda exists.
	 * @return the contacts list.
	 */
	public List<Contact> getContactsView(){
		return contactsView;
	}

	/**
	 * This method returns the subject list used for the visibility for the user.
	 * <b>Pre:</b> the agenda exists.
	 * @return the contacts list.
	 */
	public List<Subject> getSubjectView(){
		return subjectView;
	}

	/**
	 * This method lists all the subjects stored on the agenda until now.
	 * <b>Pos:</b> the subjects are stored on a list.
	 */
	public void listOfSubjects() {
		subjectView = new ArrayList<Subject>(subjects.values());
	}

	/**
	 * This method lists all the contacts stored on the agenda until now.
	 * (on alphabetical order using lexicographic order).
	 * <b>Pos:</b> the contacts are stored in alphabetical order inside a list. 
	 */
	public void listOfContacts() {

		contactsView = new ArrayList<Contact>(contacts.values());

		Collections.sort(contactsView, new Comparator<Contact>() {

			@Override
			public int compare(Contact o1, Contact o2) {

				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				}else if (o1.getName().compareTo(o2.getName()) < 0) {
					return -1;
				}else {
					return 0;
				}	
			}
		});	
	}
	
	public void editContact(int pos, String id, String name, String email, String phoneNumber, 
			LocalDate dateOfBirth, int age, int enrolledcreditsnumber ) {
		
		contacts.get(id).setName(name);
		contacts.get(id).setEmail(email);
		contacts.get(id).setPhonenumber(phoneNumber);
		contacts.get(id).setDateOfBirth(dateOfBirth);
		contacts.get(id).setAge(age);
		contacts.get(id).setEnrolledCredits(enrolledcreditsnumber);
		
		contactsView.get(pos).setName(name);
		contactsView.get(pos).setEmail(email);
		contactsView.get(pos).setPhonenumber(phoneNumber);
		contactsView.get(pos).setDateOfBirth(dateOfBirth);
		contactsView.get(pos).setAge(age);
		contactsView.get(pos).setEnrolledCredits(enrolledcreditsnumber);
		
		
		
	}
	
	public int getIndexInGlobalSubjects(String name) {
		
		
		return subjectView.indexOf(subjects.get(name));
		
	}
	
	public int getIndexInParticularContact(String id, String name) {
		
		int index = -1;
		
		if (contacts.get(id).getMySubjects().containsKey(name)) {
			List<Subject> sub = contacts.get(id).getListOfSubjects();
			index = sub.indexOf(contacts.get(id).getMySubjects().get(name));
		}
		
		return index;
		
	}
	
	public int getIndexInGlobalContacts(String key) {
		
		Contact con = contacts.get(key);
		
		return contactsView.lastIndexOf(con);
		
	}
	
	/**
	 * This method adds a new entry contact 
	 * <b>Pre:</b> the information of the contact is valid
	 * <b>Pos:</b> the contact has been added as a new entry to the agenda
	 * @param id the unique identifier
	 * @param avatar the visual representation
	 * @param name the complete name
	 * @param email the contact email
	 * @param phonenumber the contact number
	 * @param dateofbirth the date of birth
	 * @param age the age
	 * @return a boolean that indicates either if the contact could be added or not.
	 */
	public boolean addContact(String id, String avatar, String name, String email, String phonenumber,LocalDate dateofbirth, int age) {

		boolean added = false;
		
		Contact newContact = new Contact(id, avatar, name, email, phonenumber, dateofbirth, age, 0);

		if (!contacts.containsKey(id)) {
			contacts.put(id, newContact);
			added = true;
			writeContacts();
			listOfContacts();
			
		}
		
		return added;
	}

	/**
	 * This method deletes a contact by its name
	 * <b>Pre:</b> the name is valid
	 * <b>Pos:</b> the contact is deleted
	 * @param name the name of the contact to be deleted
	 * @return a boolean that indicate either if the contact could be deleted or not.
	 */
	public boolean deleteContact(String id) {

		boolean deleted = false;

		if (contacts.containsKey(id)) {
			
			for (Subject sub : contacts.get(id).getMySubjects().values()) {
				int n = sub.getStudentsEnrolled();;
				subjects.get(sub.getName()).setStudentsEnrolled(n-1);;
			}
			
			contacts.remove(id);
			deleted = true;
			contactsView.remove(contacts.get(id));
			
			writeContacts();
			listOfContacts();
			
			
		}

		return deleted;
	}

	/**
	 * This method searchs a contact by its unique identifier.
	 * <b>Pre:</b> the unique identifier is valid.
	 * <b>Pos:</b> the contact searched is returned.
	 * @param id the unique identifier of the contact to be searched.
	 * @return the entry with the contact that match with the unique identifier received.
	 */
	public Contact searchByID(String id){

		return contacts.get(id);

	}

	/**
	 * This method searchs a contact by its name.
	 * <b>Pre:</b> the name is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param name the name of the contact(s) to be searched.
	 */
	public void searchByName(String name){
		
		contactsView = new ArrayList<Contact>();
		List<Contact> contactss = new ArrayList<Contact>(contacts.values());


		for (int i = 0; i < contactss.size(); i++) {
			if (contactss.get(i).getName().contains(name)) {
				contactsView.add(contactss.get(i));
			}
		}


	}

	/**
	 * This method searchs a contact by its age.
	 * <b>Pre:</b> the age is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param age1 the age of the contact(s) to be searched.
	 * @param operation indicates if we are looking for an age equal, after or before the given age
	 */
	public void searchByAge(int age1, int operation){
		contactsView = new ArrayList<Contact>();
		List<Contact> contactss = new ArrayList<Contact>(contacts.values());
		
		if (operation == 0) {

			for (int i = 0; i < contactss.size(); i++) {
				if (contactss.get(i).getAge() == age1) {
					contactsView.add(contactss.get(i));
				}
			}

		}else if (operation == 1) { //buscar menores a age1

			for (int i = 0; i < contactss.size(); i++) {
				if (contactss.get(i).getAge() < age1) {
					contactsView.add(contactss.get(i));
				}
			}

		}else if (operation == 2) { //buscar mayores a age1

			for (int i = 0; i < contactss.size(); i++) {
				if (contactss.get(i).getAge() > age1) {
					contactsView.add(contactss.get(i));
				}
			}

		}

	}


	/**
	 * This method searchs a contact by its date of birth.
	 * <b>Pre:</b> the date of birth is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param day1 the day of birth of the contact(s) to be searched.
	 * @param month1 the month of birth of the contact(s) to be searched.
	 * @param day2 the second day used to search on an interval.
	 * @param month2 the second month used to search on an interval.
	 * @param operation indicates if we are looking for a date equal, after or before the given date
	 */
	public void searchByDateOfBirth(int day1, int month1, int day2, int month2, int operation){

		contactsView  = (List<Contact>) contacts.values();

		if (operation == 0) { // fechas iguales a day1/month1

			for (int i = 0; i < contactsView.size(); i++) {
				if(contactsView.get(i).getDateOfBirth().getDayOfMonth() != day1 || 
						contactsView.get(i).getDateOfBirth().getMonthValue() != month1) {

					contactsView.remove(i);
				}
			}

		}else if (operation == 1) { // fechas en el mismo mes

			for (int i = 0; i < contactsView.size(); i++) {

				if (contactsView.get(i).getDateOfBirth().getMonthValue() != month1) {
					contactsView.remove(i);
				}

			}

		}else if (operation == 2) { // fechas entre dos meses

			for (int i = 0; i < contactsView.size(); i++) {

				if (contactsView.get(i).getDateOfBirth().getMonthValue() < month1 ||
						contactsView.get(i).getDateOfBirth().getMonthValue() > month2) {
					contactsView.remove(i);
				}

			}

		}else {
			searchBetweenTwoDates(day1, month1, day2, month2);
		}

	}

	/**
	 * This method searchs a contact between two dates.
	 * <b>Pre:</b> the date of birth is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param day1 the first day used to search on an interval.
	 * @param month1 the first month used to search on an interval.
	 * @param day2 the second day used to search on an interval.
	 * @param month2 the second month used to search on an interval.
	 */
	private void searchBetweenTwoDates(int day1, int month1, int day2, int month2) {
		
		contactsView = new ArrayList<Contact>();
		//List<Contact> contactss = new ArrayList<Contact>(contacts.values());


		for (int i = 0; i < contactsView.size(); i++) {

			if (contactsView.get(i).getDateOfBirth().getMonthValue() < month1 
					|| contactsView.get(i).getDateOfBirth().getMonthValue() > month2) {

				contactsView.remove(i);

			}else if ((contactsView.get(i).getDateOfBirth().getDayOfMonth() < day1 && contactsView.get(i).getDateOfBirth().getMonthValue() == month1) 
					|| (contactsView.get(i).getDateOfBirth().getDayOfMonth() > day2 && contactsView.get(i).getDateOfBirth().getMonthValue() == month2)) {

				contactsView.remove(i);

			}

		}

	}

	public List<String> getContactsName(){
		contactsName = new ArrayList<String>();
		for (int i = 0; i < contactsView.size(); i++) {
			contactsName.add(contactsView.get(i).getName());
		}
		return contactsName;
	}

	/**
	 * This method searchs a contact by a subject.
	 * <b>Pre:</b> the subject name is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param name the name of the subject that the contact(s) would have added to their lists.
	 */
	public void searchBySubject(String name){ 

		contactsView = new ArrayList<Contact>(contacts.values());

		for (int i = 0; i < contactsView.size(); i++) {
			if (!contactsView.get(i).getMySubjects().containsKey(name)) {
				contactsView.remove(i);
			}
		}
		
		

	}

	/**
	 * This method created a new subject that later will be available to be add to a contact subject's list.
	 * <b>Pre:</b> the given data is valid.
	 * <b>Pos:</b> the subject is created.
	 * @param name the name of the subject
	 * @param numberOfCredits the number of credits of the subject.
	 * @return a boolean that indicates either if the subject could be created or not.
	 */
	public boolean createSubject(String name, int numberOfCredits) {

		boolean created = false;

		if (!subjects.containsKey(name)) {
			Subject sub  = new Subject(name, numberOfCredits, 0);
			subjects.put(name, sub);
			created = true;
		}
		return created;
	}
	
	public boolean deleteSubject(String name) {
		
		boolean deleted = false;
		
		if (subjects.containsKey(name)) {
			
			for (Contact con : contacts.values()) {
				
				if (con.getMySubjects().containsKey(name)) {
					con.getMySubjects().remove(name);
					int act = con.getEnrolledCredits();
					int cre = con.getMySubjects().get(name).getNumberCredits();
					con.setEnrolledCredits(act - cre);
				}
				
			}
			
			subjects.remove(name);
			deleted = true;
			
		}
		
		return deleted;
	}

	/**
	 * This method adds a new subject to a contact subject's list. 
	 * <b>Pre:</b> the information of the subject is valid.
	 * <b>Pos:</b> the subject has been added to a contact in the agenda. 
	 * @param subjectName the name of the subject
	 * @param studentId the unique identifier of the student that is going to add this subject.
	 * @return a boolean that indicates either if the subject could be added or not.
	 */
	public boolean addSubject(String subjectName, String studentId) { 

		boolean added = false;
		
		if (subjects.containsKey(subjectName) && contacts.containsKey(studentId)) {
			
			contacts.get(studentId).getMySubjects().put(subjectName, subjects.get(subjectName));
			int x = subjects.get(subjectName).getStudentsEnrolled();
			subjects.get(subjectName).setStudentsEnrolled(x+1);

			int y = contacts.get(studentId).getEnrolledCredits();
			int c = subjects.get(subjectName).getNumberCredits();

			contacts.get(studentId).setEnrolledCredits(y+c);
			
			added = true;
		}

		return added;
	}

	/**
	 * This method removes a subject from a contact's subject's list.
	 * <b>Pre:</b> the name is valid.
	 * <b>Pos:</b> the subject is removed.
	 * @param subjectName the name of the subject to be removed.
	 * @param studentId the unique identifier of the student that is going to remove this subject.
	 * @return a boolean that indicate either if the contact could be deleted or not.
	 */
	public boolean removeSubject(String subjectName, String studentId) {

		boolean removed = false;

		if (contacts.containsKey(studentId)) {

			if (contacts.get(studentId).getMySubjects().containsKey(subjectName)) {
				contacts.get(studentId).getMySubjects().remove(subjectName);
				int x = subjects.get(subjectName).getStudentsEnrolled();
				subjects.get(subjectName).setStudentsEnrolled(x-1);

				int y = contacts.get(studentId).getEnrolledCredits();
				int c = subjects.get(subjectName).getNumberCredits();
				
				contacts.get(studentId).setEnrolledCredits(y-c);

				removed = true;
			}

		}
		return removed;
	}

	/**
	 * This method calculates which is the more enrolled subject between all the contacts students in the agenda.
	 * @return the more enrolled subject.
	 */
	public Subject moreEnrolledSubject() {

		List<Subject> list = new ArrayList<Subject>(subjects.values());

		Collections.sort(list, new Comparator<Subject>() {

			@Override
			public int compare(Subject o1, Subject o2) {

				if (o1.getStudentsEnrolled() > o2.getStudentsEnrolled()) {
					return 1;

				}else if (o1.getStudentsEnrolled() < o2.getStudentsEnrolled()) {
					return -1;

				}else {
					System.out.println();
					return 0;
				}
			}
		});
		
		return list.get(list.size()-1);
	}

	/**
	 * This method calculates which is the less enrolled subject between all the contacts students in the agenda.
	 * @return the less enrolled subject.
	 */
	public Subject lessEnrolledSubject() {

		List<Subject> list = new ArrayList<Subject>(subjects.values());
		Collections.sort(list, new Comparator<Subject>() {

			@Override
			public int compare(Subject o1, Subject o2) {
				if (o1.getStudentsEnrolled() > o2.getStudentsEnrolled()) {
					return 1;

				}else if (o1.getStudentsEnrolled() < o2.getStudentsEnrolled()) {

					return -1;

				}else {
					return 0;
				}
			}
		});
		
		
		return list.get(0);
	}

	/**
	 * This method reads the information from a database to create the subjects available for contacts
	 * <b>Pre:</b> the file exists.
	 * <b>Pos:</b> the information of the subjects is read and the subjects are created.
	 */
	private void readSubjects(){
		try {
			FileReader fr = new FileReader(new File(PATH_SUBJECTS));
			BufferedReader br = new BufferedReader(fr);

			StringTokenizer st;
			String line = br.readLine();

			while(line != null) {

				st = new StringTokenizer(line, ",");

				String name = st.nextToken();
				int credits = Integer.valueOf(st.nextToken());
				int studentsEnrolled = Integer.valueOf(st.nextToken());

				Subject sub = new Subject(name, credits, studentsEnrolled);
				subjects.put(name, sub);

				line = br.readLine();

			}

			br.close();
			fr.close();
		}catch(IOException e) {
			System.err.println(e);
		}

	}

	/**
	 * This method reads the information from a databse to create the contacts available for the first time the program launchs.
	 * <b>Pre:</b> the file exists.
	 * <b>Pos:</b> the information of the contacts is read and the contacts are created.
	 */
	private void readStudents(){
		try {
			FileReader fr = new FileReader(new File(PATH_STUDENTS));
			BufferedReader br = new BufferedReader(fr);

			StringTokenizer st;
			String line = br.readLine();
			String[] p;

			while(line != null) {
				
				p = line.split(",");
				st = new StringTokenizer(line, ",");

				String id = st.nextToken();
				String avatar = st.nextToken();
				String name = st.nextToken();
				String email = st.nextToken();
				String phoneNumber = st.nextToken();
				String date = st.nextToken();
				String[] parts = date.split("/");
					int year = Integer.valueOf(parts[2]);
					int month = Integer.valueOf(parts[1]);
					int day = Integer.valueOf(parts[0]);
				LocalDate date2 = LocalDate.of(year, month, day);
				int age = Integer.valueOf(st.nextToken());
				
				Contact con = new Contact(id, avatar, name, email, phoneNumber, date2, age, 0);
				contacts.put(id, con);
				
				for (int i = 8; i < p.length; i++) {
					addSubject(p[i], id);
					
				}
			
				line = br.readLine();
			}
			br.close();
			fr.close();
		}catch(IOException e) {

		}
	}

	/**
	 * This method overrides the contacts database everytime information is edited or a new contact entry is added.
	 * <b>Pre:</b> the contacts exists.
	 * <b>Pos:</b> the information of the contacts is overrided.
	 */
	public void writeContacts() {
		String message = "";

		List<Contact> con = new ArrayList<Contact>(contacts.values());

		for (Contact c : con) {

			int d = c.getDateOfBirth().getDayOfMonth();
			int m = c.getDateOfBirth().getMonthValue();
			int y = c.getDateOfBirth().getYear();

			String date = d + "/" + m + "/" + y;

			try {
				List<Subject> sub = new ArrayList<Subject>(c.getMySubjects().values());
				String materias = "";
				for (int i = 0; i < sub.size(); i++) {
					materias += "," + sub.get(i).getName();
				}
				
				message += c.getId() + "," + c.getAvatar() + "," + c.getName() + "," + c.getEmail() + "," + c.getPhonenumber()
				+ "," + date + "," + c.getAge() + "," + c.getEnrolledCredits() + materias + "\n";

				FileWriter fw;

				fw = new FileWriter(PATH_STUDENTS);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);

				out.print(message);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method overrides the subjects database everytime information is edited.
	 * <b>Pre:</b> the subjects exists.
	 * <b>Pos:</b> the information of the subjects is overrided.
	 */
	public void writeSubjects() {
		String message = "";

		List<Subject> sub = new ArrayList<Subject>(subjects.values());

		for (Subject c : sub) {
			try {
				message += c.getName() + "," + c.getNumberCredits() + "," + c.getStudentsEnrolled() + "\n";

				FileWriter fw;

				fw = new FileWriter(PATH_SUBJECTS);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);

				out.print(message);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void sort(String criterio) {

		switch (criterio) {

		case ORDER_NAME:

			listOfContacts();

			break;

		case ORDER_AGE:

			contactsView = new ArrayList<Contact>(contacts.values());

			Collections.sort(contactsView, new Comparator<Contact>() {

				@Override
				public int compare(Contact o1, Contact o2) {

					if (o1.getAge() > o2.getAge()) {
						return 1;
					}else if (o1.getAge() < o2.getAge()) {
						return -1;
					}else {
						return 0;
					}	
				}
			});	

			break;

		case ORDER_BIRTHDAY:

			contactsView = new ArrayList<Contact>(contacts.values());

			Collections.sort(contactsView, new Comparator<Contact>() {

				@Override
				public int compare(Contact o1, Contact o2) {

					if (o1.getDateOfBirth().getMonth().compareTo(o2.getDateOfBirth().getMonth()) > 0) {
						return 1;
					}else if (o1.getDateOfBirth().getMonth().compareTo(o2.getDateOfBirth().getMonth()) < 0) {
						return -1;
					}else {
						
						if (o1.getDateOfBirth().getDayOfMonth() > o2.getDateOfBirth().getDayOfMonth()) {
							return 1;
						}else if (o1.getDateOfBirth().getDayOfMonth() < o2.getDateOfBirth().getDayOfMonth()) {
							return -1;
						}else {
							return 0;
						}
						
					}	
				}
			});	
			
			
			break;

		default:
			break;
		}

	}
}