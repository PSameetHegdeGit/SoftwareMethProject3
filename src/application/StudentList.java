/**
 * This class defines a Student List and its operations
 * Its methods are called when adding, removing, and printing students
 * @author Abhijit Bhatt, Sameet Hegde
 */

package application;

public class StudentList {
	
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4;
	private Student [] list; 
	private int numStudents;
	
	/**
	 * Constructor that initializes Student array
	 */
	public StudentList() {
		
		list = new Student[GROW_SIZE];
	}

	/**
	 * This method adds a student to the list if they are not already in the list
	 * @param s  Student object to be added
	 */
	public String add(Student s) {
		String addString = new String();
		
		if(find(s) == -1) {
			int i = 0;
			try {
				while(list[i] != null) {
					i++;
				}
				list[i] = s;
				numStudents++;
			} 
			catch(Exception e) {
				grow();
				add(s);
			}	
		}
		else {
			System.out.println("\nCannot Add! student already in list");
			addString = addString + "\nCannot Add! student already in list";
		}
		
		return addString;
		
		
	}
	
	/**
	 * This method removes a student from the list if the student is present
	 * @param s  Student to be removed from list
	 */
	public String remove(Student s) {
		
		String removeString = new String("");
		
		 if (isEmpty()) {
			   System.out.println("\nList is empty!");
			   removeString = removeString + "\nList is empty!";
			   return removeString;
		   }
		   else {
			   int studentIndex = find(s);
			   if( studentIndex != -1) {
				   list[studentIndex] = list[numStudents-1];
				   list[numStudents-1] = null;
				   numStudents--;
				   
				   System.out.println(s.toString() + " has been unenrolled.");
				   removeString = removeString + s.toString() + " has been unenrolled.";
				   
				   return removeString;
			   }
		   }
		   System.out.println(s.toString() + " is not enrolled.");
		   removeString = removeString + s.toString() + " is not enrolled.";
	       return removeString;
	}
	
	/**
	 * This method prints all students currently on the list and their tuitions
	 */
	public String print() {
		
		String printString = new String();
		
		if(numStudents == 0) {
			System.out.println("List is empty");
			printString = printString + "List is empty";
			return printString;
		}
 
		System.out.println("\nWe have the following Students:\n");
		printString = printString + "\nWe have the following Students:\n";

		for(int i = 0; i < numStudents; i++) {
			  
			String student = ((Student)list[i]).toString();
			int tuitionDue = ((Student)list[i]).tuitionDue();   
			  
			  System.out.println(student + " " + "tuition due: " + tuitionDue);
			  printString = printString + student + " " + "tuition due: " + tuitionDue + "\n";
		  }
		
		System.out.println("--End of List--"); 
		printString = printString + "--End of List--";
		
		return printString;
	}
	
	
	/**
	 * This method finds a student by comparing first name and last name of student with list[i] first name and last name
	 * @param s  Student to be searched for
	 * @return index of student
	 */
	private int find(Student s) {
		int i = 0;
		
		String name = null;
		
		while (i < numStudents) {
			
			if(list[i] instanceof Instate) {
				name = ((Instate)list[i]).get_fname() +  " " + ((Instate)list[i]).get_lname();
			}
			else if(list[i] instanceof Outstate) {
				name = ((Outstate)list[i]).get_fname() +  " " + ((Outstate)list[i]).get_lname();
			}
			else if (list[i] instanceof International) {
				name = ((International)list[i]).get_fname() +  " " + ((International)list[i]).get_lname();
			}
			
			int bool = s.compareTo(name);
			
			if(bool == 0) {
				return i;
			}
			
			i++;
		}
		return -1;
			
	}
	
	/**
	 * This method grows the student array by 4
	 */
	private void grow() {
		
		 Student [] newList = new Student[sizeOfList(list) + 4];
	     int size = sizeOfList(list);
	      
	     for(int i = 0; i < size; i++) {
	    	 newList[i] = list[i];
	     }
	    list = newList;
	}
		   
	
	/**
	 * This method computes the student array
	 * @param list  array whose size is to be determined
	 * @return  number of students in list
	 */
	private int sizeOfList(Student [] list) {
		
		int size = 0;
		Student sizechecker;
		try {
			
			while (true) {
				
				sizechecker = list[size];
				size++;
			}
		}
		catch(Exception e) { 
		   
		}
		
		return size;
	}

	/**
	 * This method checks to see if the list is empty
	 * @return true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		
		int i = 0;
		Student emptyChecker;
		int size = sizeOfList(list);
		while (i < size) {
			emptyChecker = list[i];
			if (emptyChecker != null) {
				return false;
			}
			i++;
		}
		numStudents = 0;
	    return true;
	}
	
	
}
