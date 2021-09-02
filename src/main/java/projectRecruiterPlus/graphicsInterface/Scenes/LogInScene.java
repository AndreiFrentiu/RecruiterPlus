package projectRecruiterPlus.graphicsInterface.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Other.TimeCounter;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;

public class LogInScene {

	public static void scene(Stage window) {
		BorderPane border = new BorderPane();
		border.setCenter(addCenter(window));
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleLoginScene.css");

		Scene scene1_Login = new Scene(border, 1920, 1080);
		window.setScene(scene1_Login);
		window.show();
	}

	private static VBox addCenter(Stage window) {
		VBox layoutLogIn = new VBox(20);
		final Label shadow = new Label("  ");
		final Label labelWelcome = new Label("Welcome!");
		final Label labelUsername = new Label("Username:");
		final Label labelPassword = new Label("Password:");

		labelWelcome.setId("title");

		TextField textField = new TextField();
		textField.setMaxSize(250, 50);
		textField.setPromptText("Your username");

		PasswordField passwordField = new PasswordField();
		passwordField.setMaxSize(250, 50);
		passwordField.setPromptText("Your password");

		HBox buttons = addButtons(window, textField, passwordField, shadow);

		layoutLogIn.setAlignment(Pos.CENTER);
		layoutLogIn.setSpacing(10);
		layoutLogIn.getChildren().addAll(labelWelcome, labelUsername, textField, labelPassword, passwordField, buttons,
				shadow);

		return layoutLogIn;
	}

	private static HBox addButtons(Stage window, TextField textField, PasswordField passwordField, Label shadow) {
		HBox buttons = new HBox(20);
		Button logInButton = new Button("Login");
		Button exitButton = new Button("Exit");

		logInButton.getStyleClass().add("fancy-button");
		logInButton.setOnAction(e -> {
			
			User user = new User(textField.getText(), passwordField.getText());
			if (App.resources.getDaoUser().verifyPassword(user) && App.resources.getDaoUser().verifyIfExists(user)) {
				// Aici
				App.resources.setMainUser(App.resources.getDaoUser().getbyUsername(user.getUsername()));
				// Acolo
				if (App.resources.getMainUser().isActiveAccount()) {
					App.timeCounter.start();
					AdminScene.scene(window);
				} else {
					App.resources.setMainUser(new User());
					shadow.setTextFill(Color.web("#FFFFFF"));
					shadow.setText("Account is inactive! Please contact your administrator.");
				}
			} else {
				shadow.setTextFill(Color.web("#FFFFFF"));
				shadow.setText("Username and password not accepted!");
			}

			System.out.println("Log In button");

		});
		exitButton.getStyleClass().add("fancy-button");
		exitButton.setOnAction(e -> {
			if (AlertBoxExit.display()) {
				window.close();
			}
			System.out.println("Exit program!");
		});

		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(10);
		buttons.getChildren().addAll(logInButton, exitButton);

		return buttons;
	}
}
