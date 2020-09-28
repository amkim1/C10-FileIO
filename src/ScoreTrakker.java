/**
 * @author Alex Kim
 * @author Mohammed Alnasser
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Class to convert files of students to an ordered output
 */
public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	/**
	 * 
	 * @param fileName name of the file to be processed
	 * @throws FileNotFoundException if the file is not found
	 */
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner scanner = new Scanner(reader);
		
		// Get the next line of the file
		while (scanner.hasNext()) {
			String name =  scanner.nextLine();
			String score = scanner.nextLine();
			try {
				// Initialize a new student and add it to the ArrayList
				Student student = new Student(name, Integer.parseInt(score));
				students.add(student);
			}
			// The score is not formatted correctly
			catch(NumberFormatException e) {
				System.out.println("Incorrect format for " + name + " not a valid score: " + score );
				System.out.println();
			}
		}
		

	}
	/**
	 * Prints the ArrayList of students in an ordered fashion
	 */
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for (Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println();
	}
	
	/**
	 * Processes all of our files
	 */
	public void processFiles() {
		for (String file : files) {
			try {
				loadDataFromFile(file);
				printInOrder();
				// Clear the ArrayList to not duplicate the students - should use the set data structure for this
				students.removeAll(students);
				
			}
			// Handle the throws clause from loadDataFromFile(file)
			catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + file);
				System.out.println();
			}
		}
		
	}

	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
