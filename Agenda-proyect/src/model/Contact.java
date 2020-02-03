package model;
import java.time.LocalDate;

public class Contact {
	
	private String avatar;
	private String name;
	private String email;
	private String phonenumber;
	private LocalDate dateofbirth;
	private int age;
	private int enrolledcreditsnumber;
	
	
	private Contact (String avatar, String name, String email, String phonenumber,LocalDate dateofbirth, int age) {
		this.avatar = avatar;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.dateofbirth = dateofbirth;
		this.age = age;
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
	
	public LocalDate getDateOfBirth() {
		return dateofbirth;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
