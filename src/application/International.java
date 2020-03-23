/**
 * This class defines the properties of an international student
 * Its methods are used to compute tuition and format an international student's information as a string
 * @author Abhijit Bhatt, Sameet Hegde
 */

package application;


public class International extends Student {

	private boolean exchange;
	private String fname;
	private String lname;

	/**
	 * Constructor that sets information of student
	 * @param fname first name of student
	 * @param lname last name of student
	 * @param credit credit hours of student
	 * @param exchange true if student is an exchange student, false otherwise
	 */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.fname = fname;
		this.lname = lname;
		this.exchange = exchange;
	}

	@Override
	/**
	 * This method calculates the amount of tuition an international student owes
	 * @return amount of tuition owed by student
	 */
	public int tuitionDue() {
		if (exchange) {
			return 1441 + 350;
		} else {

			if (credit < 12) {
				return (credit * 945) + 846 + 350;
			} else if (credit > 15) {
				return (15 * 945) + 1441 + 350;
			} else
				return (credit * 945) + 1441 + 350;
		}
	}

	/**
	 * This method is used to get student's first name
	 * @return first name of student
	 */
	public String get_fname() {
		return fname;
	}
	
	/**
	 * This method is used to get student's last name
	 * @return last name of student
	 */
	public String get_lname() {
		return lname;
	}
	
	
	@Override
	/**
	 * This method formats an international student's information as a string
	 * @return name, credits, and exchange status of student as string
	 */
	public String toString() {
		return super.toString() + " " + exchange;
	}

	/**
	 * Test bed main to test methods
	 * @param args
	 */
	public static void main(String [] args) {
		//Test 1
		System.out.println("International class Test 1: Calling constructor and then returning to string method.");
		
		International student = new International("Justin", "Yu", 12, true);
		System.out.println(student.toString());
		
		International student2 = new International("Sam", "Hedge", 13, false);
		System.out.println(student2.toString());
		
		//Test 2
		System.out.println("\nInternational Test 2: Calling tuitionDue function on student and student2");
		System.out.println("Tuition Due @ 12 credits and exchange: " + student.tuitionDue()); //12 credits and exchange
		
		student.credit = 17;
		System.out.println("Tuition Due @ 17 credits and exchange: " + student.tuitionDue()); //17 credits and exchange;
		
		student.exchange = false;
		System.out.println("Tuition Due @ 17 credits and not exchange: " + student.tuitionDue()); //17 credits and not exchange
		
		student.credit = 14; 
		System.out.println("Tuition Due @ 14 credits and not exchange: " + student.tuitionDue()); // 14 credits and not exchange
		
		student.credit = 9; 
		System.out.println("Tuition Due @ 9 credits and not exchange: " + student.tuitionDue()); // 9 credits and not exchange
		
		//Test 3
		System.out.println("\nOutstate Test 3: Call Get Functions");
		System.out.println("first name of student: "+ student.get_fname());
		System.out.println("last name of student: "+ student.get_lname());
		
		
	}
	
	
	
}