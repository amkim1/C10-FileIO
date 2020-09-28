import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };


	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner scanner = new Scanner(reader);
		while (scanner.hasNext()) {
			String[] line =  scanner.nextLine().split(" ");
			try {
				Student student = new Student(line[0] + " " + line[1], Integer.parseInt(line[2]));
				students.add(student);
			}
			catch(NumberFormatException e) {
				System.out.println("Incorrect format for " + line[0] + " " + line[1] + " not a valid score: " + line[2] );
			}
		}


	}

	public void printInOrder() {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	public void processFiles() {
		for (String file : files) {
			try {
				loadDataFromFile(file);
				printInOrder();
			} catch(FileNotFoundException e) {
				System.out.println("Can't open file: " + file);
			}
		}
	}

	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		System.out.println("Student Score List");
		trakker.processFiles();
	}
}
