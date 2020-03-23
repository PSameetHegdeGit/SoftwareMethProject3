package application;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class Controller {
	
	TuitionManager tm = new TuitionManager();
	
	@FXML Button add;
	@FXML Button remove;
	@FXML Button print;
	
	@FXML private RadioButton instate; 
	@FXML private RadioButton outstate;
	@FXML private RadioButton international;
	
	
	@FXML private CheckBox funding;
	@FXML private CheckBox tristateStudent;
	@FXML private CheckBox exchangeStudent;
	
	@FXML private TextField fundingAmount;
	
	
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
			funding.setDisable(false);
			fundingAmount.setDisable(false);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(true);
		}
		if(outstate.isSelected()) {
			System.out.println("Outstate Selected");
			fundingAmount.setDisable(true);
			funding.setDisable(true);
			tristateStudent.setDisable(false);
			exchangeStudent.setDisable(true);
		}
		if(international.isSelected()) {
			System.out.println("International Selected");
			fundingAmount.setDisable(true);
			funding.setDisable(true);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(false);
		}
		
	}
	
	//handles each function
	@FXML
	public void clickAdd(ActionEvent event) {
		System.out.println("Test add function");
		System.out.println(fundingAmount.getText());
	}
	
	public void clickRemove(ActionEvent event) {
		System.out.println("Test remove function");
		
	}
	public void clickPrint(ActionEvent event) {
		System.out.println("Test print function");
	}
	

	
	
}
