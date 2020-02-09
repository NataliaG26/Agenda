package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.SimpleFormatter;

import javafx.scene.control.ListView;

/**
 * This class manage the necessary attributes and methods to create agenda.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class Agenda {

	private Hashtable<String, Contact> contacts;
	private Hashtable<String, Subject> subjects;

	//contact's list visible for the user
	private List<Contact> contactsView;

	//paths to read text files with information required
	public final static String PATH_SUBJECTS = "data/subjects.txt";
	public final static String PATH_STUDENTS = "data/students.txt";

	//Searching interests
	public final static String SEARCH_NAME = "Nombre";
	public final static String SEARCH_BIRTHDAY = "Cumpleaños";
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

	//public final static String ORDER = "Ordenar";
	//Sorting interests
	public final static String ORDER_NAME = "Por nombre A-Z";
	public final static String ORDER_BIRTHDAY = "Por fecha de cumpleaños";
	public final static String ORDER_AGE = "Por edad";

	public final static String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

	/**
	 * <b>Agenda Constructor</b>
	 */
	public Agenda() {

		contacts = new Hashtable<String, Contact>();
		subjects = new Hashtable<String, Subject>();

		readStudents();
		readSubjects();

		writeContacts();
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

		if (!contacts.containsKey(name)) {
			contacts.put(name, newContact);
			added = true;
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
	public boolean deleteContact(String name) {

		boolean deleted = false;

		if (!contacts.containsKey(name)) {
			contacts.remove(name);
			deleted = true;
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

		List<Contact> list = (List<Contact>) contacts.values();

		list.sort(new Comparator<Contact>() {

			@Override
			public int compare(Contact o1, Contact o2) {

				if(o1.getId().compareTo(o2.getId()) > 0)
					return 1;
				else if(o1.getId().compareTo(o2.getId()) < 0)
					return -1;
				else 
					return 0;
			}

		});

		int index = binarySearch(list, 0, list.size()-1, id);

		if (index == -1) {
			return null;
		}else {
			return list.get(index);
		}
	}

	/**
	 * This method uses binary searching to search inside the contacts list.
	 * <b>Pre:</b> the key is valid.
	 * <b>Pos:</b> the contact that match with the key is returned.
	 * @param list the contact´s list with the contacts of interest.
	 * @param l the first index of the list.
	 * @param r the last index of the list.
	 * @param key the attribute to be compare with the rest inside the list to partitionate the list.
	 * @return the index where is located the contact that match with the key received.
	 */
	private int binarySearch(List<Contact> list, int l, int r, String key) {

		if (r >= l) { 
			int mid = l + (r - l) / 2; 


			if (list.get(mid).getId().compareToIgnoreCase(key) == 0) 
				return mid; 


			if (list.get(mid).getId().compareToIgnoreCase(key) > 0) 
				return binarySearch(list, l, mid - 1, key); 


			return binarySearch(list, mid + 1, r, key); 
		} 

		return -1; 
	}

	/**
	 * This method searchs a contact by its name.
	 * <b>Pre:</b> the name is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param name the name of the contact(s) to be searched.
	 * @return the list that contains all the possible entries that match with the received name.
	 */
	public List<Contact> searchByName(String name){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getName().equalsIgnoreCase(name)) {
				list.remove(i);
			}
		}

		return list;
	}

	/**
	 * This method searchs a contact by its age.
	 * <b>Pre:</b> the age is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param age the age of the contact(s) to be searched.
	 * @return the list that contains all the possible entries that match with the received age.
	 */
	public List<Contact> searchByAge(int age){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge() != age) {
				list.remove(i);
			}
		}

		return list;
	}

	/**
	 * This method searchs a contact by its date of birth.
	 * <b>Pre:</b> the date of birth is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param date the date of birth of the contact(s) to be searched.
	 * @return the list that contains all the possible entries that match with the received date of birth.
	 */
	public List<Contact> searchByDateOfBirth(LocalDate date){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getDateOfBirth().equals(date)) {
				list.remove(i);
			}
		}

		return list;
	}

	/**
	 * This method searchs a contact by a subject.
	 * <b>Pre:</b> the subject name is valid.
	 * <b>Pos:</b> the list with the possible matchings is returned.
	 * @param name the name of the subject that the contact(s) would have added to their lists.
	 * @return the list that contains all the possible entries that match with the received subject's name.
	 */
	public List<Contact> searchBySubject(String name){ 

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getMySubjects().containsKey(name)) {
				list.remove(i);
			}
		}

		return list;
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

					return 0;
				}
			}
		});
		return list.get(0);
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
		return list.get(list.size()-1);
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

			while(line != null) {

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
				int enrolledcreditsnumber = Integer.valueOf(st.nextToken());

				Contact con = new Contact(id, avatar, name, email, phoneNumber, date2, age, enrolledcreditsnumber);
				contacts.put(id, con);

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
				message += c.getId() + "," + c.getAvatar() + "," + c.getName() + "," + c.getEmail() + "," + c.getPhonenumber()
				+ "," + date + "," + c.getAge() + "," + c.getEnrolledCredits() + "\n";

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
}