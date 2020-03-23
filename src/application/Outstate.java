/**
 * This class defines the properties of an out-of-state student
 * Its methods are used to compute tuition and format an out-of-state student's information as a string
 * @author Abhijit Bhatt, Sameet Hegde
 */

package application;

public class Outstate extends Student {

	private boolean tristate;
	private String fname;
	private String lname;

	/**
	 * Constructor that sets information of student
	 * @param fname first name of student
	 * @param lname last name of student
	 * @param credit credit hours of student
	 * @param tristate true if student is from tristate area, false otherwise
	 */
	public Outstate(String fname, String lname, int credit, boolean tristate) {
		super(fname, lname, credit);
		this.fname = fname;
		this.lname = lname;
		this.tristate = tristate;
	}

	@Override
	/**
	 * This method calculates the amount of tuition an out-of-state student owes
	 * @return amount of tuition owed by student
	 */
	public int tuitionDue() {

		if (tristate) {

			if (credit < 12) {
				return (credit * 756) + 846;
			} else if (credit > 15) {
				return (15 * 556) + 1441;
			} else
				return (credit * 556) + 1441;

		} else {

			if (credit < 12) {
				return (credit * 756) + 846;
			} else if (credit > 15) {
				return (15 * 756) + 1441;
			} else
				return (credit * 756) + 1441;
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
	 * This method formats an out-of-state student's information as a string
	 * @return name, credits, and tristate status of student as string
	 */
	public String toString() {
		return super.toString() + " " + tristate;
	}

	/**
	 * Test bed main to test methods
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Test 1
		System.out.println("Outstate class Test 1: Calling constructor and then returning to string method.");
		
		Outstate student = new Outstate("Sheldon", "Cooper", 12, true);
		System.out.println(student.toString());
		
		Outstate student2 = new Outstate("Raj", "Koothrapalli", 13, false);
		System.out.println(student2.toString());
		
		//Test 2
		System.out.println("\nOutstate Test 2: Calling tuitionDue function on student");
		System.out.println("Tuition Due @ 12 credits and tristate: " + student.tuitionDue()); //12 credits and tristate
		
		student.credit = 17;
		System.out.println("Tuition Due @ 17 credits and tristate: " + student.tuitionDue()); //17 credits and tristate;
		
		student.tristate = false;
		System.out.println("Tuition Due @ 17 credits and not tristate: " + student.tuitionDue()); //17 credits and not tristate
		
		student.credit = 14; 
		System.out.println("Tuition Due @ 14 credits and not tristate: " + student.tuitionDue()); // 14 credits and not tristate
		
		student.credit = 9; 
		System.out.println("Tuition Due @ 9 credits and not tristate: " + student.tuitionDue()); // 9 credits and not tristate
		
		//Test 3
		System.out.println("\nOutstate Test 3: Call Get Functions");
		System.out.println("first name of student: "+ student.get_fname());
		System.out.println("last name of student: "+ student.get_lname());
		
	}

}