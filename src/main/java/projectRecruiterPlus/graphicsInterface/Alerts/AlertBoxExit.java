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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AlertBoxExit {
	
	static boolean answer;
	
	public static boolean display() {
	
		BorderPane border = new BorderPane();
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Exit game");
		window.setMinWidth(250);
		
		final Label label = new Label("Are you sure you want to exit ?");
		final Label shadow = new Label(" ");
			
		Button exitGame = new Button("Exit game");
		Button returnToGame = new Button("Cancel");
		returnToGame.setOnAction(e -> {
			answer = false;
			window.close();
		});
		exitGame.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(shadow, label);
		layout.setAlignment(Pos.CENTER);
		border.setTop(layout);
		
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(returnToGame, exitGame);
		buttons.setAlignment(Pos.CENTER);
		border.setCenter(buttons);
		
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleExitGame.css");

		Scene scene = new Scene(border, 250, 125);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}

}
