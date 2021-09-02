package projectRecruiterPlus.graphicsInterface.Scenes;

import java.time.LocalDate;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;

public class NewUserScene {

	private static ChoiceBox<String> roles = new ChoiceBox<>();
	private static final Label invalidInput = new Label(" ");

	private static TextField usernameTextField = new TextField();
	private static TextField passwordTextField = new TextField();
	private static TextField firstNameTextField = new TextField();
	private static TextField lastnameTextField = new TextField();
	private static TextField adressTextField = new TextField();
	private static TextField emailTextField = new TextField();

	private static TextField grossTextField = new TextField();
	private static TextField netTextField = new TextField();
	private static DatePicker birthdayPicker = new DatePicker();
	private static DatePicker firstdayPicker = new DatePicker();
	private static ChoiceBox<String> vacationDaysChoice = new ChoiceBox<>();
	private static CheckBox checkBoxaccountStatus = new CheckBox("Active");

	public static void scene() {

		BorderPane border = new BorderPane();
		Stage window = new Stage();
		border.setCenter(addContent(window));
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAddUserScene.css");
		window.initModality(Modality.APPLICATION_MODAL);
		Scene scene1_Login = new Scene(border, 720, 720);
		window.setScene(scene1_Login);
		window.setOnCloseRequest(e -> {
			e.consume();
			if (AlertBoxExit.display()) {
				window.close();
			}
		});

		window.showAndWait();
	}

	private static VBox addContent(Stage window) {
		VBox layoutAddUser = new VBox(20);
		layoutAddUser.setAlignment(Pos.CENTER);

		Button next = new Button("Next");
		next.getStyleClass().add("fancy-button");
		next.setOnAction(e -> {
			if (validUser()) {
				User newUser = createUser();
			}
			// TODO + send user
			// NewUserScene2.scene(roles.getValue(window, newUser));
		});

		layoutAddUser.getChildren().addAll(addBigInfo(), addImportantInfo(), invalidInput, next);
		return layoutAddUser;

	}

	private static User createUser() {
		invalidInput.setText("Ii bini!");
		return null;
	}

	private static boolean validUser() {
		invalidInput.setTextFill(Color.web("#F08080"));
		int validations = 0;
		int notNulls = 0;
		if (validSalary(grossTextField.getText(), netTextField.getText())) {
			validations++;
		}
		if (validEmail(emailTextField.getText())) {
			validations++;
		}
		if (validPassword(passwordTextField.getText())) {
			validations++;
		}
		if (validUsername(usernameTextField.getText())) {
			validations++;
		}
		if(firstNameTextField.getText().equals("")) {
			firstNameTextField.setStyle("-fx-border-color: red;");
		} else {
			firstNameTextField.setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		if(lastnameTextField.getText().equals("")) {
			lastnameTextField.setStyle("-fx-border-color: red;");
		} else {
			lastnameTextField.setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		if(adressTextField.getText().equals("")) {
			adressTextField.setStyle("-fx-border-color: red;");
		} else {
			adressTextField.setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		if (validations ==4 && notNulls==3) {
			return true;
		}
		if (validations ==4) {
			invalidInput.setText("Please fill in the blanks");
		}
		return false;
	}

	private static boolean validSalary(String gross, String net) {
		int grossValue = 0, netValue = 0;
		boolean exit = false;
		try {
			grossValue = Integer.parseInt(gross);
		} catch (Exception e) {
			grossTextField.setStyle("-fx-border-color: red;");
			invalidInput.setText("Gross is not a valid number");
			exit = true;
		}
		try {
			netValue = Integer.parseInt(net);
		} catch (Exception e) {
			netTextField.setStyle("-fx-border-color: red;");
			invalidInput.setText("Net is not a valid number");
			exit = true;
		}
		if (exit) {
			return false;
		}
		if (grossValue < netValue) {
			grossTextField.setStyle("-fx-border-color: red;");
			netTextField.setStyle("-fx-border-color: red;");
			invalidInput.setText("Net is bigger then Gross");
			return false;
		}
		grossTextField.setStyle("-fx-border-color: blue;");
		netTextField.setStyle("-fx-border-color: blue;");
		return true;
	}

	private static boolean validEmail(String text) {
		char[] email = text.toCharArray();
		boolean condi1 = false;
		boolean condi2 = false;
		for (char c : email) {
			if (c == '@') {
				condi1 = true;
			}
			if (c == '.' && condi1) {
				condi2 = true;
			}
		}
		if (condi1 && condi2) {
			emailTextField.setStyle("-fx-border-color: blue;");
			return true;
		}
		invalidInput.setText("invalid Email");
		emailTextField.setStyle("-fx-border-color: red;");
		return false;
	}

	private static boolean validUsername(String text) {
		if (text.length() < 5) {
			invalidInput.setText("Username needs to have more then 4 characters!");
			usernameTextField.setStyle("-fx-border-color: red;");
			return false;
		}
		usernameTextField.setStyle("-fx-border-color: blue;");
		return true;
	}

	private static boolean validPassword(String pass) {
		String answer = "Invalid Password! The password need to have:";
		char[] password = pass.toCharArray();
		boolean smallLetter = false;
		boolean bigLetter = false;
		boolean number = false;
		boolean specialCharacter = false;
		boolean space = false;
		for (char c : password) {
			if (c >= 33 && c <= 47 || c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 126)
				specialCharacter = true;
			if (c >= 97 && c <= 122)
				smallLetter = true;
			if (c >= 65 && c <= 90)
				bigLetter = true;
			if (c >= 48 && c <= 57)
				number = true;
			if (c == 32)
				space = true;
		}
		if (pass.length() < 8)
			answer = answer + " more then 7 characters,";
		if (!smallLetter)
			answer = answer + " at least one small letter,";
		if (!bigLetter)
			answer = answer + " at least one big letter,";
		if (!number)
			answer = answer + " at least one number,";
		if (!specialCharacter)
			answer = answer + " at least one special character,";
		if (space) {
			invalidInput.setText("Can't use space password");
			passwordTextField.setStyle("-fx-border-color: red;");
		} else if (answer.equals("Invalid Password! The password need to have:")) {
			passwordTextField.setStyle("-fx-border-color: blue;");
			return true;
		} else {
			passwordTextField.setStyle("-fx-border-color: red;");
			invalidInput.setText(answer.substring(0, answer.length() - 1) + "!");
		}

		return false;
	}

	private static HBox addImportantInfo() {
		HBox importantInfo = new HBox(40);
		HBox role = new HBox(20);
		HBox team = new HBox(20);
		final Label roleLab = new Label("Set Role");
		final Label teamLab = new Label("Set Team");
		ChoiceBox<String> teamsChoice = new ChoiceBox<>();
		List<TeamOfRecruitment> teamOfRec = App.resources.getDaoTeamRec().getAll();

		role.setAlignment(Pos.CENTER);
		role.getChildren().addAll(roleLab, roles);

		roles.getItems().addAll("Manager", "TeamLead", "Recruiter", "Custom Role");
		roles.setValue("Recruiter");

		for (TeamOfRecruitment teamOfRecruitment : teamOfRec) {
			teamsChoice.getItems().add(teamOfRecruitment.getName());
		}
		teamsChoice.setValue(teamOfRec.get(0).getName());
		teamsChoice.getSelectionModel().selectedItemProperty()
				.addListener((v, oldValue, newValue) -> System.out.println("test"));

		team.getChildren().addAll(teamLab, teamsChoice);
		team.setAlignment(Pos.CENTER);

		importantInfo.getChildren().addAll(role, team);
		importantInfo.setAlignment(Pos.CENTER);

		return importantInfo;
	}

	private static HBox addBigInfo() {
		HBox bigInfo = new HBox(25);
		bigInfo.getChildren().addAll(addLeftGridPane(), addRightGridPane());
		bigInfo.setAlignment(Pos.CENTER);
		return bigInfo;
	}

	private static GridPane addRightGridPane() {
		GridPane gridRight = new GridPane();

		final Label gross = new Label("Gross Salary:");
		final Label net = new Label("Net Salary:");
		final Label birthday = new Label("Birthday:");
		final Label firstday = new Label("Start date:");
		final Label vacationDays = new Label("Vacation Days:");
		final Label accountStatus = new Label("Account Status:");

		grossTextField.setMinSize(50, 25);
		grossTextField.setMaxWidth(200);
		grossTextField.setPromptText("0.0");

		netTextField.setMinSize(50, 25);
		netTextField.setMaxWidth(200);
		netTextField.setPromptText("0.0");

		vacationDaysChoice.getItems().addAll("21 Format", "23 Format", "25 Format");
		vacationDaysChoice.setValue("21 Format");
		vacationDaysChoice.setMaxWidth(200);

		birthdayPicker.setMaxWidth(200);
		birthdayPicker.setValue(LocalDate.now());
		firstdayPicker.setMaxWidth(200);
		firstdayPicker.setValue(LocalDate.now());
		vacationDaysChoice.setMaxWidth(200);

		gridRight.setHgap(10);
		gridRight.setVgap(15);
		gridRight.setAlignment(Pos.CENTER);
		gridRight.add(gross, 0, 0);
		gridRight.add(grossTextField, 1, 0);
		gridRight.add(net, 0, 1);
		gridRight.add(netTextField, 1, 1);
		gridRight.add(birthday, 0, 2);
		gridRight.add(birthdayPicker, 1, 2);
		gridRight.add(firstday, 0, 3);
		gridRight.add(firstdayPicker, 1, 3);
		gridRight.add(vacationDays, 0, 4);
		gridRight.add(vacationDaysChoice, 1, 4);
		gridRight.add(accountStatus, 0, 5);
		gridRight.add(checkBoxaccountStatus, 1, 5);
		gridRight.setAlignment(Pos.CENTER);

		return gridRight;
	}

	private static GridPane addLeftGridPane() {
		GridPane gridLeft = new GridPane();

		final Label username = new Label("Username:");
		final Label password = new Label("Password:");
		final Label firstName = new Label("First Name:");
		final Label lastname = new Label("Last Name:");
		final Label adress1 = new Label("Adress:");
		final Label email = new Label("Email:");

		usernameTextField.setMinSize(50, 25);
		usernameTextField.setMaxWidth(200);
		usernameTextField.setPromptText("exampleOfUserName");
		passwordTextField.setMinSize(50, 25);
		passwordTextField.setMaxWidth(200);
		passwordTextField.setPromptText("Example123!");
		firstNameTextField.setMinSize(50, 25);
		firstNameTextField.setMaxWidth(200);
		firstNameTextField.setPromptText("first name");
		lastnameTextField.setMinSize(50, 25);
		lastnameTextField.setMaxWidth(200);
		lastnameTextField.setPromptText("last name");
		adressTextField.setMinSize(50, 25);
		adressTextField.setMaxWidth(200);
		adressTextField.setPromptText("Str. , Nr. , Ap.");
		emailTextField.setMinSize(50, 25);
		emailTextField.setMaxWidth(200);
		emailTextField.setPromptText("example@there.com");

		gridLeft.setHgap(10);
		gridLeft.setVgap(12);
		gridLeft.setAlignment(Pos.CENTER);
		gridLeft.add(username, 0, 0);
		gridLeft.add(usernameTextField, 1, 0);
		gridLeft.add(password, 0, 1);
		gridLeft.add(passwordTextField, 1, 1);
		gridLeft.add(firstName, 0, 2);
		gridLeft.add(firstNameTextField, 1, 2);
		gridLeft.add(lastname, 0, 3);
		gridLeft.add(lastnameTextField, 1, 3);
		gridLeft.add(adress1, 0, 4);
		gridLeft.add(adressTextField, 1, 4);
		gridLeft.add(email, 0, 5);
		gridLeft.add(emailTextField, 1, 5);
		gridLeft.setAlignment(Pos.CENTER);

		return gridLeft;
	}

}
