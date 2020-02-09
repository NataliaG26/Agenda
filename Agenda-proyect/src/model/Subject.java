package model;

/**
 * This class manage the necessary attributes and methods to create Subjects for contacts.
 * @author Natalia Isabel Gonzalez
 * @author Lina Johanna Salinas
 * @author Luis Felipe Sanchez
 * @author Juan José Valencia 
 * @version 1.0
 *
 */
public class Subject {

	private String name;
	private int numberCredits;
	private int studentsEnrolled;

	/**
	 * <b>Subject Constructor</b>
	 * @param name the name of the subject
	 * @param numberCredits the number of credits assigned to this subject
	 * @param studentsEnrolled the number of students with this subject on their lists
	 */
	public Subject(String name, int numberCredits, int studentsEnrolled) {

		this.name = name;
		this.numberCredits = numberCredits;
		this.studentsEnrolled = 0;

	}

	/**
	 * This method returns the name of this subject everytime it is required.
	 * <b>Pre:</b> The subject exists.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name of the subject in the case that the user wants to edit information.
	 *<b>Pre:</b> the subject exists.
	 *<b>Pos:</b> the name of the subject is edited.
	 * @param name the new value for the attribute name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the number of credits for this subject everytime it is required.
	 * <b>Pre:</b> The subject exists.
	 * @return the number of credits.
	 */
	public int getNumberCredits() {
		return numberCredits;
	}

	/**
	 * This method sets the number of credits for this subject in the case that the user wants to edit information.
	 *<b>Pre:</b> the subject exists.
	 *<b>Pos:</b> the number of credits for this subject is edited.
	 * @param numberCredits the new value for the attribute number of credits.
	 */
	public void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}

	/**
	 * This method returns the number of enrolled students on this subject everytime it is required.
	 * <b>Pre:</b> The subject exists.
	 * @return the number of enrolled students.
	 */
	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}

	/**
	 * This method sets the number of enrolled students for this subject in the case that the user wants to edit information.
	 *<b>Pre:</b> the subject exists.
	 *<b>Pos:</b> the number of enrolled students for this subject is edited.
	 * @param studentsEnrolled the new value for the attribute number of enrolled students.
	 */
	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
}