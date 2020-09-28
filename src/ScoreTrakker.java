import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void loadDataFromFile(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNext()) {
				String[] line =  scanner.nextLine().split(" ");
				Student student = new Student(line[0] + line[1], Integer.parseInt(line[2]));
				students.add(student);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void printInOrder() {
		for (Student student : students) {
			student.toString();
		}
	}
	
	public void processFiles() {
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		System.out.println("Student Score List");
		trakker.processFiles();
	}
}
