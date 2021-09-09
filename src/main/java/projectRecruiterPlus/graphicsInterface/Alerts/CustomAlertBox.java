package projectRecruiterPlus.graphicsInterface.Alerts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomAlertBox {
	 private boolean answer;
	 private String question = " ", button1_True= " ", button2_False= " ";
	 
	public CustomAlertBox(String question, String button1_True, String button2_False) {
		this.question = question;
		this.button1_True = button1_True;
		this.button2_False = button2_False;
	}

	public boolean display() {
		BorderPane border = new BorderPane();
		Stage window = new Stage(); 
		final Label questionLabel = new Label();
		final Label shadow = new Label(" ");
		Button yes = new Button(button1_True);
		Button no = new Button(button2_False);
		VBox layout = new VBox(10);
		HBox buttons = new HBox(10);
		Scene scene = new Scene(border, 250, 150);
		
		questionLabel.setText(question);	
		yes.setOnAction(e -> {
			answer = true;
			window.close();
		});
		no.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		layout.getChildren().addAll(shadow, questionLabel);
		layout.setAlignment(Pos.CENTER);
		
		buttons.getChildren().addAll(yes, no);
		buttons.setAlignment(Pos.CENTER);
		
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleExitProgram.css");
		border.setCenter(buttons);
		border.setTop(layout);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Attention!");
		window.setMinWidth(250);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}

}
