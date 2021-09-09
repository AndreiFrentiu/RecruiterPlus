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
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AlertBoxExit {
	
	private boolean answer;
	
	public boolean display() {
		BorderPane border = new BorderPane();
		Stage window = new Stage();
		Button exitGame = new Button("Exit");
		Button returnToGame = new Button("Cancel");
		final Label label = new Label("Are you sure you want to exit ?");
		final Label shadow = new Label(" ");
		VBox layout = new VBox(10);
		HBox buttons = new HBox(10);
		Scene scene = new Scene(border, 250, 125);
		returnToGame.setOnAction(e -> {
			answer = false;
			window.close();
		});
		exitGame.setOnAction(e -> {
			answer = true;
			window.close();
		});
		layout.getChildren().addAll(shadow, label);
		layout.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(returnToGame, exitGame);
		buttons.setAlignment(Pos.CENTER);
		border.setCenter(buttons);
		border.setTop(layout);
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleExitProgram.css");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Exit App");
		window.setMinWidth(250);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}

}
