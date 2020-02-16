package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * This class manage the necessary attributes and methods to create Contacts entries.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class Contact {

	private String id;
	private String avatar;
	private String name;
	private String email;
	private String phonenumber;
	private LocalDate dateofbirth;
	private int age;
	private int enrolledcreditsnumber;
	private Hashtable<String, Subject> mySubjects;

	/**
	 * <b>Contact Constructor</b> 
	 * @param id the unique identifier of the contact. 
	 * @param avatar the visual representation of the entry.
	 * @param name the name of the contact.
	 * @param email the contact email of the contact.
	 * @param phonenumber the contact number of the contact.
	 * @param dateofbirth the date of birth of the contact.
	 * @param age the age of the contact.
	 * @param enrolledcreditsnumber the number of enrolled credits in the case of having subjects.
	 */
	public Contact (String id, String avatar, String name, String email, String phonenumber,
			LocalDate dateofbirth, int age, int enrolledcreditsnumber) {

		this.id = id;
		this.avatar = avatar;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.dateofbirth = dateofbirth;
		this.age = age;
		this.enrolledcreditsnumber = enrolledcreditsnumber;
		mySubjects = new Hashtable<String, Subject>();
	}
	
	/**
	 * This method returns the id of this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the id.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * This method returns the visual representation of this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the visual representation.
	 */
	public String getAvatar() {
		return avatar;
	}
	

	/**
	 * This method sets the visual representation for this contact in the case that the user wants to edit information.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the visual representation for this contact is edited.
	 * @param avatar the new value for the visual representation of the current contact.
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	/**
	 * This method returns the name of this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name for this contact in the case that the user wants to edit information.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the name for this contact is edited.
	 * @param name the new value for the name of the current contact.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the email for this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the email.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method sets the contact email for this contact in the case that the user wants to edit information.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the contact email for this contact is edited.
	 * @param email the new value for the contact email of the current contact.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method returns the number of contact for this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the contact number.
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	
	/**
	 * This method sets the contact number for this contact in the case that the user wants to edit information.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the contact number for this contact is edited.
	 * @param phoneNumber the new value for the contact number of the current contact.
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	/**
	 * This method returns the date of birth for this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the birth of date.
	 */
	public LocalDate getDateOfBirth() {
		return dateofbirth;
	}

	/**
	 * This method returns a string representation of the date of birth for this contact
	 * <b>Pre:</b> the contact exists.
	 * @return a string representation of the date composed by day and month(in letters)
	 */
	public String toStringDateOfBirth() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dateofbirth.format(format);
	}
	
	/**
	 * This method returns the age for this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This method sets the age for this contact in the case that the user wants to edit information.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the age for this contact is edited.
	 * @param age the new value for the age of the current contact.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method returns the number of enrolled credits for this contact everytime it is required.
	 * <b>Pre:</b> The contact exists.
	 * @return the number of enrolled credits.
	 */
	public int getEnrolledCredits() {
		return enrolledcreditsnumber;
	}
	
	/**
	 * This method sets the number of enrolled credits for this contact in the case that the the user adds a new subject
	 * on the subject's list of the current contact.
	 *<b>Pre:</b> the contact exists.
	 *<b>Pos:</b> the number of enrolled credits for this contact is edited.
	 * @param enrolledCreditsNumber the new value for the number of enrolled credits of the current contact.
	 */
	public void setEnrolledCredits(int enrolledCreditsNumber) {
		this.enrolledcreditsnumber = enrolledCreditsNumber;
	}

	/**
	 * This method returns the subject's list for this contact.
	 * <b>Pre:</b> the contact exists.
	 * @return the subject's list.
	 */
	public Hashtable<String, Subject> getMySubjects(){
		return mySubjects;
	}
	
	public List<Subject> getListOfSubjects(){
		
		List<Subject> l = new ArrayList<Subject>(mySubjects.values());
		System.out.println(l.size());
		return l;
		
	}
}



