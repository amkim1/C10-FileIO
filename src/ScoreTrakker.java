import java.util.ArrayList;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	public void loadDataFromFile(String fileName) {
		
	}
	
	public void printInOrder() {
		
	}
	
	public void processFiles() {
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
