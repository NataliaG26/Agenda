package model;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

public class Contact {
	
	private String id;
	private String avatar;
	private String name;
	private String email;
	private String phonenumber;
	private Date dateofbirth;
	private int age;
	private int enrolledcreditsnumber;
	private Hashtable<String, Subject> mySubjects;
	
	
	public Contact (String id, String avatar, String name, String email, String phonenumber,
			Date dateofbirth, int age, int enrolledcreditsnumber) {
		
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

	public String getId() {
		return id;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public Date getDateOfBirth() {
		return dateofbirth;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getEnrolledCredits() {
		return enrolledcreditsnumber;
	}
	
	public void setEnrolledCredits(int enrolledCreditsNumber) {
		this.enrolledcreditsnumber = enrolledCreditsNumber;
	}
	
	public Hashtable<String, Subject> getMySubjects(){
		return mySubjects;
	}
}












