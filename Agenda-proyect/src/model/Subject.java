package model;

public class Subject {
	
	private String name;
	private int numberCredits;
	private int studentsEnrolled;
	
	public Subject(String name, int numberCredits, int semester) {
		
		this.name = name;
		this.numberCredits = numberCredits;
		this.studentsEnrolled = 0;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberCredits() {
		return numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}


	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}
	
	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

}
