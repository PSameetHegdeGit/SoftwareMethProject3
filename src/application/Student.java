package application;

/**
* This class defines the name and credits of a student
* Its methods are called to check for equivalent students and to format a student's properties as a string
* @author Sameet Hegde, Abhijit Bhatt
*/
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	protected int credit;
	
	/**
	 * Constructor that sets first name, last name, and credit hours of a student
	 * @param fname first name of student
	 * @param lname last name of student
	 * @param credit number of credit hours of student
	 */
	public Student(String fname, String lname, int credit) {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	}
	
	/**
	 * This method checks if student names are the same
	 * @param obj student object to be compared
	 */
	public int compareTo(Object obj) {
		
		String checker = fname + " " + lname;
		
		return checker.compareToIgnoreCase(obj.toString());	
	}
	
	/**
	 * This method formats the student's properties as a string
	 * @return  Student's information as a string
	 */
	public String toString() {
		return fname + " " + lname + " " + credit;
	}
	
	/**
	 * This is an abstract method used to calculate a student's tuition
	 * @return tuition amount in dollars
	 */
	public abstract int tuitionDue();
	
	
}
