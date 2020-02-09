/**
 * 
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 
 *
 */
public class Agenda {

	private Hashtable<String, Contact> contacts;
	private Hashtable<String, Subject> subjects;

	public final static String PATH_SUBJECTS = "Data/subjects.txt";
	public final static String PATH_STUDENTS = "Data/students.txt";
	
	public final static String SEARCH_NAME = "Nombre";
	public final static String SEARCH_LAST_NAME = "Apellido";
	public final static String SEARCH_BIRTHDAY = "Cumpleaños";
	public final static String SEARCH_AGE = "Edad";
	
	public final static String FILTER_BIRTHDAY = "Fecha exacta";
	public final static String FILTER_BIRTHDAY_BETWEEN_DATES = "Entre dos meses";
	public final static String FILTER_BIRTHDAY_DATE = "Entre dos meses";
	public final static String FILTER_BIRTHDAY_BETWEEN_MONTHS = "Entre dos meses";
	public final static String FILTER_BIRTHDAY_MONTHS = "Entre dos meses";
	public final static String FILTER_AGE_OLDER = "Mayor que";
	public final static String FILTER_AGE_JOUNGER = "Mayor que";

	public final static String ORDER = "Ordenar";
	public final static String ORDER_NAME = "Por nombre";
	public final static String ORDER_LAST_NAME = "Por apellido";

	
	public Agenda() {

		contacts = new Hashtable<String, Contact>();
		subjects = new Hashtable<String, Subject>();
		/*
		readStudents();
		readSubjects();*/

	}

	public boolean addContact(String id, String avatar, String name, String email, String phonenumber,LocalDate dateofbirth, int age) {

		boolean added = false;

		Contact newContact = new Contact(id, avatar, name, email, phonenumber, dateofbirth, age);

		if (!contacts.containsKey(name)) {
			contacts.put(name, newContact);
			added = true;
		}

		return added;

	}

	public boolean deleteContact(String name) {

		boolean deleted = false;

		if (!contacts.containsKey(name)) {
			contacts.remove(name);
			deleted = true;
		}

		return deleted;

	}


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

	public List<Contact> searchByName(String name){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getName().equalsIgnoreCase(name)) {
				list.remove(i);
			}
		}

		return list;

	}

	public List<Contact> searchByAge(int age){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge() != age) {
				list.remove(i);
			}
		}

		return list;

	}

	public List<Contact> searchByDateOfBirth(LocalDate date){

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getDateOfBirth().equals(date)) {
				list.remove(i);
			}
		}

		return list;

	}

	public List<Contact> searchBySubject(String name){ 

		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getMySubjects().containsKey(name)) {
				list.remove(i);
			}
		}

		return list;

	}
	/*
	public boolean addSubject(String name) { //need to read from the txt file to create the subject

		boolean added = false;

		if (!subjects.containsKey(name)) {
			subjects.put(name, new Subject(name, 0, 0, 0));
			added = true;
		}

		return added;

	}

	public boolean removeSubject(String name) {

		boolean removed = false;

		if (subjects.containsKey(name)) {
			subjects.remove(name);
			removed = true;
		}

		return removed;

	}*/

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

	public Hashtable<String, Contact> getContacts(){

		return contacts;

	}

	public Hashtable<String, Subject> getSubjects(){

		return subjects;

	}

	private void readSubjects() {
		
		try {
		FileReader fr = new FileReader(new File(PATH_SUBJECTS));
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		String[] parts = line.split(",");
		while(line != null){

			String name = parts[0];
			int credits = Integer.valueOf(parts[1]);
			int nrc = Integer.valueOf(parts[2]); 
			int studentsEnrolled = Integer.valueOf(parts[3]);
			
			Subject sub = new Subject(name, credits, nrc, studentsEnrolled);
			
			subjects.put(name, sub);

			line = br.readLine();
			if(line != null) {
				parts = line.split(",");
			}
		}

		br.close();
		fr.close();
		}catch(IOException e) {
			System.err.println(e);
		}

	}

	private void readStudents(){
		try {
		FileReader fr = new FileReader(new File(PATH_STUDENTS));
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		String[] parts = line.split(",");
		while(line != null){

			//read


			line = br.readLine();
			if(line != null) {
				parts = line.split(",");
			}
		}

		br.close();
		fr.close();
		}catch(IOException e) {
			System.err.println(e);
		}

	}

}




















