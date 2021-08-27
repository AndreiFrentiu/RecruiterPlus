package projectRecruiterPlus.graphicsInterface.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.Scenes.AdminSceneAbstract;
import projectRecruiterPlus.Util.Other.CompanyRoleType;

public class AdminScene extends AdminSceneAbstract{

	public static void scene(Stage window) {
			
		Button exitInButton = new Button("Exit");
		exitInButton.getStyleClass().add("fancy-button");
		exitInButton.setOnAction(e -> {
			LogInScene.scene(window);
		});
		
		Button testButton = new Button("test");
		testButton.getStyleClass().add("fancy-button");
		testButton.setOnAction(e -> {
			User user = new User("1", "1");
			System.out.println(App.resources.getDaoUser().updateUsername(user, "test"));
		});

		VBox layoutLogIn = new VBox(20);
		layoutLogIn.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		layoutLogIn.setAlignment(Pos.CENTER);
		layoutLogIn.setSpacing(10);
		layoutLogIn.getChildren().addAll(exitInButton, testButton);
		Scene scene2_Admin = new Scene(layoutLogIn, 1920, 1080);
		
		window.setScene(scene2_Admin);
		window.setMaximized(true);
		window.show();
	}
}
