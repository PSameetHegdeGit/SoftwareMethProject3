/**
 * This class defines the properties of an instate student
 * Its methods are used to compute tuition and format an instate student's information as a string
 * @author Abhijit Bhatt, Sameet Hegde
 */

package application;

public class Instate extends Student {

	private int funds;
	private String fname;
	private String lname;

	/**
	 * Constructor that sets information of student
	 * @param fname first name of student
	 * @param lname last name of student
	 * @param credit credit hours of student
	 * @param funds amount of funding student receives
	 */
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.fname = fname;
		this.lname = lname;
		this.funds = funds;
	}

	@Override
	/**
	 * This method calculates the amount of tuition an instate student owes
	 * @return amount of tuition owed by student
	 */
	public int tuitionDue() {
		int owed;
		if (credit < 12) {
			owed = (credit * 433) + 846;
			
		} else if (credit > 15) {
			owed = (15 * 433) + 1441 - funds;
		}
		else {
			owed = (credit * 433) + 1441 - funds;
		}
		
		if (owed <= 0) {
			return 0;
		}
		else {
			return owed;
		}
	}

	@Override
	/**
	 * This method formats an instate student's information as a string
	 * @return name, credits, and funding of instate student as string
	 */
	public String toString() {
		return super.toString() + " " + funds;
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
	

	/**
	 * Test bed main to test methods
	 * @param args
	 */
	public static void main(String[] args) {
		//Test 1
		System.out.println("Instate class Test 1: Calling constructor and then returning to string method.");
				
		Instate student = new Instate("George", "Jeffrey", 12, 100);
		System.out.println(student.toString());
				
		Instate student2 = new Instate("Patrick", "Ennis", 13, 1000);
		System.out.println(student2.toString());
		
		//Test 2
		System.out.println("\nInstate Test 2: Calling tuitionDue function on student and student2");
		
		student.funds = 0;
		System.out.println("Tuition Due @ 12 credits and $0 funding: " + student.tuitionDue()); //12 credits
				
		student.credit = 17;
		student.funds = 100;
		System.out.println("Tuition Due @ 17 credits and $100 funding: " + student.tuitionDue()); //17 credits
				
		student.funds = 500;
		System.out.println("Tuition Due @ 17 credits and $500 funding: " + student.tuitionDue()); //17 credits 
				
		student.credit = 14;
		student.funds = 1000;
		System.out.println("Tuition Due @ 14 credits and $1000 funding: " + student.tuitionDue()); // 14 credits 
				
		student.credit = 9; 
		student.funds = 10000;
		System.out.println("Tuition Due @ 9 credits and $10000: " + student.tuitionDue()); // 9 credits 
				
		//Test 3
		System.out.println("\nOutstate Test 3: Call Get Functions");
		System.out.println("first name of student: "+ student.get_fname());
		System.out.println("last name of student: "+ student.get_lname());
					
	}
}
