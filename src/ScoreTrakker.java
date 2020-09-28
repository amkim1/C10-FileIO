import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };


	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner scanner = new Scanner(reader);
		while (scanner.hasNext()) {
			String name =  scanner.nextLine();
			String score = scanner.nextLine();
			try {
				Student student = new Student(name, Integer.parseInt(score));
				students.add(student);
			}
			catch(NumberFormatException e) {
				System.out.println("Incorrect format for " + name + " not a valid score: " + score );
				System.out.println();
			}
		}
		

	}

	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for (Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println();
	}

	public void processFiles() {
		for (String file : files) {
			try {
				loadDataFromFile(file);
				printInOrder();
				students.removeAll(students);
				
			} catch (FileNotFoundException e) {
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
