package application;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class Controller {
	
	@FXML Button add;
	
	@FXML private RadioButton instate; 
	@FXML private RadioButton outstate;
	@FXML private RadioButton international;
	
	
	@FXML private CheckBox funding;
	@FXML private CheckBox tristateStudent;
	@FXML private CheckBox exchangeStudent;
	//@FXML private TextField fundingAmount;
	
	
	@FXML
	public void clickRadioButton(ActionEvent event) {
		if(instate.isSelected()) {
			System.out.println("Instate Selected");
			funding.setDisable(false);
			//fundingAmount.setDisable(false);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(true);
		}
		if(outstate.isSelected()) {
			System.out.println("Outstate Selected");
			//fundingAmount.setDisable(true);
			funding.setDisable(true);
			tristateStudent.setDisable(false);
			exchangeStudent.setDisable(true);
		}
		if(international.isSelected()) {
			System.out.println("International Selected");
			//fundingAmount.setDisable(false);
			funding.setDisable(true);
			tristateStudent.setDisable(true);
			exchangeStudent.setDisable(false);
		}
	}
	
	//calls add function from Tuition Manager 
	@FXML
	public void clickAdd() {
		System.out.println("Test add function");
	}

	
	
}
