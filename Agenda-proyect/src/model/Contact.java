package model;


public class Contact {
	
	private String avatar;
	private String name;
	private String email;
	private int age;
	private String phonenumber;
	
	private Contact (String avatar, String name, String email, int age, String phonenumber) {
		this.avatar = avatar;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phonenumber = phonenumber;
		
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
