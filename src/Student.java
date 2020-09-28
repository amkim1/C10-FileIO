/**
 * 
 * @author Alex Kim
 * @author Mohammed Alnasser
 *
 */

/**
 * Student class which will store students name and their score
 */
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	/**
	 * constructor for student
	 * @param name
	 * @param score
	 */
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * compareTo function to compare the names of the students
	 * @param otherStudent the other student to compare to
	 */
	@Override
	public int compareTo(Student otherStudent) {
		return name.compareTo(otherStudent.name);
	}
	
	/**
	 * toString function to print the student info
	 */
	@Override
	public String toString()  {
		return name + " " + score;
	}
}
