package application;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class Controller {
	
	TuitionManager tm = new TuitionManager() {
	
		@Override
		void addInternational(String[] tokens) {
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
			System.out.println("Sameet Is Kewl!");
			
		}
		
	
	};
	
	String studentType;
	
	@FXML Button add;
	@FXML Button remove;
	@FXML Button print;
	
	@FXML private RadioButton instate; 
	@FXML private RadioButton outstate;
	@FXML private RadioButton international;
	
	
	@FXML private CheckBox funding;
	@FXML private CheckBox tristateStudent;
	@FXML private CheckBox exchangeStudent;
	
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField credit;
	@FXML private TextField fundingAmount;
	
	@FXML private TextArea output;
	
	
	//Initializes my text 
	@FXML
	public void initialize() {
		System.out.println("Hello!");
		fundingAmount.setDisable(true);
	}
		
	//Disables checkboxes
	@FXML
	public void clickRadioButton(ActionEvent event) {
		if(instate.isSelected()) {
			System.out.println("Instate Selected");
			studentType = "I";
			funding.setDisable(false);
			fundingAmount.setDisable(false);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(true);
		}
		if(outstate.isSelected()) {
			System.out.println("Outstate Selected");
			studentType = "O";
			fundingAmount.setDisable(true);
			funding.setDisable(true);
			tristateStudent.setDisable(false);
			exchangeStudent.setDisable(true);
		}
		if(international.isSelected()) {
			System.out.println("International Selected");
			studentType = "N";
			fundingAmount.setDisable(true);
			funding.setDisable(true);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(false);
		}
		
	}
	
	//handles each function
	
	private void addInternational() {
		String tokens[] = new String[5];
		tokens[1] = firstName.getText();
		tokens[2] = lastName.getText();
		tokens[3] = credit.getText();
		tokens[4] = "F";
		if(exchangeStudent.isSelected()) {
			tokens[4] = "T";
		}
		tm.addInternational(tokens);
		
	}

	private void addOutstate() {
		String tokens[] = new String[5];
		tokens[1] = firstName.getText();
		tokens[2] = lastName.getText();
		tokens[3] = credit.getText();
		tokens[4] = "F";
		tokens[4] = "F";
		if(tristateStudent.isSelected()) {
			tokens[4] = "T";
		}
		tm.addOutstate(tokens);
		
	}

	private void addInstate() {
		String tokens[] = new String[5];
		tokens[1] = firstName.getText();
		tokens[2] = lastName.getText();
		tokens[3] = credit.getText();
		tokens[4] = "0";
		if(funding.isSelected()) {
			tokens[4] = fundingAmount.getText();
		}
		tm.addInstate(tokens);
		
	}

	
	@FXML
	private void clickAdd(ActionEvent event) {
		if(studentType == null) {
			System.out.println("Missing student type");
			return;
		}
		if(firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty() || credit.getText().trim().isEmpty()) {
			System.out.println("Blank field");
			return;
		}
		
		
		System.out.println("Test add function");
		switch(studentType) {
			case "I": addInstate(); break;
			case "O": addOutstate(); break;
			case "N": addInternational(); break;
		}
		
		System.out.println(fundingAmount.getText());
		System.out.println(firstName.getText());
		System.out.println(lastName.getText());
		System.out.println(credit.getText());
	}
	
	@FXML
	private void clickRemove(ActionEvent event) {
		String tokens[] = new String[3];
		
		if(firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty()) {
			System.out.println("Blank field");
			output.appendText("Blank Field\n");
			return;
		}
		
		tokens[1] = firstName.getText();
		tokens[2] = lastName.getText();
		tm.remove(tokens);
	}
	
	@FXML
	private void clickPrint(ActionEvent event) {
		String printString = tm.students.print();
		output.appendText(printString + "\n");
	}
	

	
	
}

