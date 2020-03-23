import java.util.Scanner;
import java.util.StringTokenizer;

/**
This class handles user input
It calls methods to add a student, remove a student, print students, or quit according to user input
@author Abhijit Bhatt, Sameet Hegde
*/
public class TuitionManager {
	
	StudentList students = new StudentList();
	
	/**
	 * This method accepts and tokenizes user input and calls methods accordingly until user quits
	 * @param args
	 */
	public static void main (String [] args) {
		
		TuitionManager tm = new TuitionManager();
		Scanner scanner = new Scanner(System.in);
		
		String student_info;
		String [] tokens;
		
		boolean done = false;
		
		while(!done) {
			System.out.println("\nEnter input: ");
			student_info = scanner.nextLine();
			
			if(student_info == null || student_info.length() == 0) {
				System.out.println("Input cannot be empty");
				continue;
			}
			
			tokens = new String[5];
			
			StringTokenizer tokenized_StudentInfo = new StringTokenizer(student_info);
		
			//Checking if # of tokens > 5
			int numOfTokens = 0;
			try {
				while(tokenized_StudentInfo.hasMoreTokens()) {
					tokens[numOfTokens] = tokenized_StudentInfo.nextToken();
					numOfTokens++;
				}
			}
			catch(Exception e){
				System.out.println("Too many tokens, invalid input!");
				continue;
			}
			
			switch(tokens[0]) {
			   case "I": 
				   if(numOfTokens == 5) {
					   tm.addInstate(tokens); 
				   }
				   else {
					   System.out.println("Invalid input: less than 5 tokens inputted");
				   }
				   break;
			   case "O": 
				   if(numOfTokens == 5) {
					   tm.addOutstate(tokens); 
				   }
				   else {
					   System.out.println("Invalid input. 5 tokens should be inputted");
				   }
				   break;
			   case "N": 
				   if(numOfTokens == 5) {
					   tm.addInternational(tokens); 
				   }
				   else {
					   System.out.println("Invalid input. 5 tokens should be inputted");
				   }
				   break;
			   case "R": 
				   if(numOfTokens == 3) {
					   tm.remove(tokens); 
					   break;
				   }
				   else {
					   System.out.println("Invalid input. Only 3 tokens should be inputted");
				   }
			   case "P": 
				   if (numOfTokens == 1) {
					   tm.students.print(); 
					   break;
				   }
				   else {
					   System.out.println("invalid input. Only 1 token should be inputted");
				   }
			   case "Q": done = true; break;
			   default: System.out.println("Invalid command");
			}
			
		}
		
		
				
	}

	/**
	 * This method checks that user input is valid for an international student.
	 * It sets the student's information and calls a method to add the student to the list.
	 * @param tokens user input to be set as student information
	 */
	private void addInternational(String[] tokens) {
		String first_name = tokens[1];
		String last_name = tokens[2];
		int credit = 1;
		
		//Checking Valid input
		try {
			credit = Integer.parseInt(tokens[3]);
		}
		catch(Exception e) {
			System.out.println("invalid input for credit");
			return;
		}
		
		if(credit < 9) {
			System.out.println("International students must have at least 9 credits");
			return;
		}
		
		if(tokens[4].length() != 1 || !(tokens[4].charAt(0) == 'T' || tokens[4].charAt(0) == 'F')) {
			System.out.println("Invalid input for ifExchange");
			return;
		}
		//End of Checking Valid input
		
		boolean bool = false;
		
		//Set bool based on value of 4th parameter of input
		if (tokens[4].equals("T")) {
			bool = true;
		}
		else if (tokens[4].equals("F")) {
			bool = false;
		}
		
		Student international_Student = new International(first_name, last_name, credit, bool);
		
		students.add(international_Student);
		
	}
	
	/**
	 * This method checks that user input is valid for an out-of-state student.
	 * It sets the student's information and calls a method to add the student to the list.
	 * @param tokens user input to be set as student information
	 */
	private void addOutstate(String[] tokens) {		
		String fname = tokens[1];
		String lname = tokens[2];
		int credit;
		
		//Checking Valid input
		try {
			credit = Integer.parseInt(tokens[3]);
		}
		catch(Exception e) {
			System.out.println("Invalid input for credit");
			return;
		}
		
		if(credit <= 0) {
			System.out.println("Students must have at least 1 credit");
			return;
		}
		
		if(tokens[4].length() != 1 || !(tokens[4].charAt(0) == 'T' || tokens[4].charAt(0) == 'F')) {
			System.out.println("Invalid input for boolean");
			return;
		}
		//End of Checking Valid input
		
		
		boolean bool = false;
		
		//Set bool based on value of 4th parameter of input
		if (tokens[4].equals("T")) {
			bool = true;
		}
		else if (tokens[4].equals("F")) {
			bool = false;
		}
		
		Student outState_Student = new Outstate(fname, lname, credit, bool); 
		students.add(outState_Student);
		
	}

	/**
	 * This method checks that user input is valid for an instate student.
	 * It sets the student's information and calls a method to add the student to the list.
	 * @param tokens user input to be set as student information
	 */
	private void addInstate(String[] tokens) {
		
		String fname = tokens[1];
		String lname = tokens[2];
		int credit;
		int funding;
		
		//Checking Valid input
		try {
			credit = Integer.parseInt(tokens[3]);
			funding = Integer.parseInt(tokens[4]);
		}
		catch(Exception e) {
			System.out.println("Invalid input");
			return;
		}
		
		if(credit <= 0) {
			System.out.println("Students must have at least 1 credit");
			return;
		}
		
		if(funding < 0) {
			System.out.println("Students cannot have negative funding");
			return;
		}
		
		//End of Checking Valid input
		
		Student instateStudent = new Instate(fname, lname, credit, funding);
		
		students.add(instateStudent);
		
	}

	/**
	 * This method sets name of student inputted by user and calls method to remove the student
	 * @param tokens  to be set as student name for removal
	 */
	private void remove (String[] tokens) {
		
		String fname = tokens[1];
		String lname = tokens[2];
		int credit = 1;
		
		Student s = new Student(fname, lname, credit) {
			@Override
			public int tuitionDue() {
				return 0;
			}
		};
		
		students.remove(s);
			
		
	}
	
}





/*
 * (1) To String fxn
 * (2) International @@
 * (3) Condense it; use Student Class more
 * (4) Add proper comments
 * (5) Verify that all the conditions are met --> All invalid inputs 
 * (6) Test bed mains
 * (7) Javadoc
 * (8) Class Diagram
 * (9) Timelogs
 */

