/**
 * 
 */
package model;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 
 *
 */
public class Agenda {

	private Hashtable<String, Contact> contacts;
	private Hashtable<String, Subject> subjects;

	public Agenda() {

		contacts = new Hashtable<String, Contact>();
		subjects = new Hashtable<String, Subject>();

	}

	public boolean addContact(String avatar, String name, String email, String phonenumber,LocalDate dateofbirth, int age) {

		boolean added = false;

		Contact newContact = new Contact(avatar, name, email, phonenumber, dateofbirth, age);

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

	public List<Contact> searchBySubject(String name){ //need that the contact to has a list of his/her subjects in order to search
													   //by subject
		List<Contact> list = (List<Contact>) contacts.values();

		for (int i = 0; i < list.size(); i++) {
			if (true) {
				list.remove(i);
			}
		}

		return list;

	}

	public boolean addSubject(String name) { //need to read from the txt file to create the subject

		boolean added = false;

		if (!subjects.containsKey(name)) {
			subjects.put(name, new Subject(name, 0, 0));
			added = true;
		}

		return added;

	}

	public boolean removeSubject(String name) {

		boolean removed = false;

		if (!subjects.containsKey(name)) {
			subjects.remove(name);
			removed = true;
		}

		return removed;

	}
	
	public Subject moreEnrolledSubject() {
		
		return null;
		
	}
	
	public Subject lessEnrolledSubject() {
		
		return null;
		
	}
	
	public Hashtable<String, Contact> getContacts(){
		
		return contacts;
		
	}
	
	public Hashtable<String, Subject> getSubjects(){
		
		return subjects;
		
	}

}




















