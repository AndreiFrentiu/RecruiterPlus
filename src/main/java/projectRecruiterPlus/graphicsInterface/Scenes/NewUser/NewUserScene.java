package projectRecruiterPlus.graphicsInterface.Scenes.NewUser;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;

@Setter
@Getter
public class NewUserScene {

	private final Label invalidInput = new Label(" ");
	private Stage window = new Stage();
	private ChoiceBox<String> roles = new ChoiceBox<>();
	private TextField usernameTextField = new TextField();
	private TextField passwordTextField = new TextField();
	private TextField firstNameTextField = new TextField();
	private TextField lastnameTextField = new TextField();
	private TextField adressTextField = new TextField();
	private TextField emailTextField = new TextField();
	private TextField grossTextField = new TextField();
	private TextField netTextField = new TextField();
	private DatePicker birthdayPicker = new DatePicker();
	private DatePicker firstdayPicker = new DatePicker();
	private ChoiceBox<String> vacationDaysChoice = new ChoiceBox<>();
	private CheckBox checkBoxaccountStatus = new CheckBox("Active");

	private GridPane gridRight = new GridPane();
	private GridPane gridLeft = new GridPane();

	private final Label username = new Label("Username:");
	private final Label password = new Label("Password:");
	private final Label firstName = new Label("First Name:");
	private final Label lastname = new Label("Last Name:");
	private final Label adress1 = new Label("Adress:");
	private final Label email = new Label("Email:");

	private final Label gross = new Label("Gross Salary:");
	private final Label net = new Label("Net Salary:");
	private final Label birthday = new Label("Birthday:");
	private final Label firstday = new Label("Start date:");
	private final Label vacationDays = new Label("Vacation Days:");
	private final Label accountStatus = new Label("Account Status:");
	
	private UserValidation userValidation;

	public void setScene() {
		BorderPane border = new BorderPane();
		Scene scene3_newUser = new Scene(border, 720, 520);
		border.setCenter(addContent());
		border.setBottom(addNextButton());
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAddUserScene.css");
		window.setScene(scene3_newUser);
		window.setOnCloseRequest(e -> {
			e.consume();
			AlertBoxExit alertBox = new AlertBoxExit();
			if (alertBox.display()) {
				window.close();
			}
		});
		window.setTitle("Create New User");
		window.initModality(Modality.APPLICATION_MODAL);
		window.show();
	}

	private VBox addContent() {
		VBox layoutAddUser = new VBox(20);
		final Label title = new Label("Insert details for new user:");
		title.setId("title");
		layoutAddUser.setAlignment(Pos.CENTER);
		layoutAddUser.getChildren().addAll(title, addUserInfo(), addRoleAndTeamInfo(), invalidInput);
		return layoutAddUser;
	}

	private HBox addUserInfo() {
		HBox bigInfo = new HBox(25);
		bigInfo.getChildren().addAll(addLeftGridPane(), addRightGridPane());
		bigInfo.setAlignment(Pos.CENTER);
		return bigInfo;
	}

	private GridPane addLeftGridPane() {
		editLeftFields();
		editLeftGrid();
		return gridLeft;
	}

	private void editLeftGrid() {
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
	}

	private void editLeftFields() {
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
	}

	private GridPane addRightGridPane() {
		editRightFields();
		editRigtGrid();
		return gridRight;
	}

	private void editRightFields() {
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
	}

	private void editRigtGrid() {
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
		gridRight.setAlignment(Pos.CENTER);// TODO Auto-generated method stub
	}

	private HBox addRoleAndTeamInfo() {
		HBox importantInfo = new HBox(40);
		HBox role = new HBox(20);
		HBox team = new HBox(20);

		final Label roleLab = new Label("Set Role");
		final Label teamLab = new Label("Set Team");
		ChoiceBox<String> teamsChoice = new ChoiceBox<>();
		List<TeamOfRecruitment> teamOfRec = App.resources.getDaoTeamRec().getAll();
		roles.getItems().addAll("Manager", "TeamLead", "Recruiter", "Application Admin");
		roles.setValue("Recruiter");

		role.setAlignment(Pos.CENTER);
		role.getChildren().addAll(roleLab, roles);

		for (TeamOfRecruitment teamOfRecruitment : teamOfRec)
			teamsChoice.getItems().add(teamOfRecruitment.getName());

		teamsChoice.setValue(teamOfRec.get(0).getName());
		teamsChoice.getSelectionModel().selectedItemProperty()
				.addListener((v, oldValue, newValue) -> System.out.println("test"));

		team.getChildren().addAll(teamLab, teamsChoice);
		team.setAlignment(Pos.CENTER);

		importantInfo.getChildren().addAll(role, team);
		importantInfo.setAlignment(Pos.CENTER);

		return importantInfo;
	}

	private VBox addNextButton() {
		final Label space = new Label(" ");
		Button next = new Button("Next");
		VBox vbox = new VBox(5);
		next.getStyleClass().add("fancy-button");
		next.setOnAction(e -> {
			//TODO
			// by pass - Delete this
			User newUser = new User();
			newUser = createUser();
			NewUserSecondScene nextWindow = new NewUserSecondScene(window, newUser);
			nextWindow.setScene(roles.getValue());

			// add this
//			User newUser = new User();
//			if (userValidation.validUser(newUser)) {
//				newUser = createUser();
//				NewUserSecondScene nextWindow = new NewUserSecondScene(window, newUser);
//				nextWindow.setScene(roles.getValue());
//			}
		});
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(next, space);
		return vbox;
	}

	private User createUser() {
		User newUser = new User(usernameTextField.getText(), passwordTextField.getText());
		newUser.setFirstName(firstNameTextField.getText());
		newUser.setLastName(lastnameTextField.getText());
		newUser.setAdress(adressTextField.getText());
		newUser.setEmail(emailTextField.getText());
		newUser.setBirthday(birthdayPicker.getValue());
		newUser.setFirstDayWork(firstdayPicker.getValue());
		newUser.setGrossSalary(Integer.parseInt(grossTextField.getText()));
		newUser.setNetSalary(Integer.parseInt(netTextField.getText()));
		newUser.setVacationDays(Integer.parseInt(vacationDaysChoice.getValue().substring(0, 2)));
		newUser.setActiveAccount(checkBoxaccountStatus.isSelected());

		return newUser;
	}

}
