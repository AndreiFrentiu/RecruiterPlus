package projectRecruiterPlus.graphicsInterface.Scenes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.Scenes.AdminSceneAbstract;
import projectRecruiterPlus.Util.Table.UserTable;

public class AdminScene extends AdminSceneAbstract {

	private static TableView<UserTable> table = new TableView<UserTable>();

	public static void scene(Stage window) {
		BorderPane bp = new BorderPane();
		bp.setLeft(addMenu());
		bp.setTop(addTop());
		bp.setCenter(addTable());
		bp.setStyle("-fx-background-image: url(\"/projectRecruiterPlus/graphicsInterface/CSS/imgs/adminbk.jpg\");"
				+ " -fx-background-repeat: no-repeat;" + "	-fx-background-size: stretch;");

		Scene scene2_Admin = new Scene(bp);
		window.setScene(scene2_Admin);
		window.setMaximized(true);
		window.show();
	}

	private static VBox addTable() {
		table.setEditable(true);
		ArrayList<UserTable> listOfUsersTable = new ArrayList<UserTable>();
		ArrayList<User> listOfUsers = (ArrayList<User>) App.resources.getDaoUser().getAll();
		for (User user : listOfUsers) {
			listOfUsersTable.add(new UserTable(user));
		}
		ObservableList<UserTable> data = FXCollections.observableArrayList(listOfUsersTable);

		TableColumn<UserTable, String> usernameCol = new TableColumn<UserTable, String>("Username");
		usernameCol.setMinWidth(150);
		usernameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("username"));

		TableColumn<UserTable, String> firstNameCol = new TableColumn<UserTable, String>("First Name");
		firstNameCol.setMinWidth(120);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("firstName"));

		TableColumn<UserTable, String> lastNameCol = new TableColumn<UserTable, String>("Last Name");
		lastNameCol.setMinWidth(120);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("lastName"));

		TableColumn<UserTable, String> emailCol = new TableColumn<UserTable, String>("Email");
		emailCol.setMinWidth(200);
		emailCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("email"));

		TableColumn<UserTable, String> adressCol = new TableColumn<UserTable, String>("Adress");
		adressCol.setMinWidth(150);
		adressCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("adress"));

		TableColumn<UserTable, LocalDate> birthdayCol = new TableColumn<UserTable, LocalDate>("Birthday");
		birthdayCol.setMinWidth(100);
		birthdayCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("birthday"));

		TableColumn<UserTable, LocalDate> firstDayOfWorkCol = new TableColumn<UserTable, LocalDate>("Start date");
		firstDayOfWorkCol.setMinWidth(100);
		firstDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("firstDayWork"));

		TableColumn<UserTable, LocalDate> lastDayOfWorkCol = new TableColumn<UserTable, LocalDate>("Last day");
		lastDayOfWorkCol.setMinWidth(100);
		lastDayOfWorkCol.setCellValueFactory(new PropertyValueFactory<UserTable, LocalDate>("lastDayWork"));

		TableColumn<UserTable, Double> grossSalaryCol = new TableColumn<UserTable, Double>("Gross Salary");
		grossSalaryCol.setMinWidth(120);
		grossSalaryCol.setCellValueFactory(new PropertyValueFactory<UserTable, Double>("grossSalary"));

		TableColumn<UserTable, Double> netSalaryCol = new TableColumn<UserTable, Double>("Net Salary");
		netSalaryCol.setMinWidth(120);
		netSalaryCol.setCellValueFactory(new PropertyValueFactory<UserTable, Double>("netSalary"));

		TableColumn<UserTable, Integer> vacationCol = new TableColumn<UserTable, Integer>("Vacation Days");
		vacationCol.setMinWidth(100);
		vacationCol.setCellValueFactory(new PropertyValueFactory<UserTable, Integer>("vacationDays"));

		TableColumn<UserTable, String> rolCol = new TableColumn<UserTable, String>("Company Role");
		rolCol.setMinWidth(120);
		rolCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("roleName"));

		TableColumn<UserTable, String> teamCol = new TableColumn<UserTable, String>("Team");
		teamCol.setMinWidth(120);
		teamCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("team"));

		table.getColumns().addAll(usernameCol, firstNameCol, lastNameCol, emailCol, adressCol, birthdayCol,
				firstDayOfWorkCol, lastDayOfWorkCol, grossSalaryCol, netSalaryCol, vacationCol, rolCol, teamCol);

		table.setItems(data);

		Button refresh = new Button("Refresh");
		refresh.getStyleClass().add("fancy-button");
		refresh.setOnAction(e -> {
			ArrayList<UserTable> listOfUsersTable2 = new ArrayList<UserTable>();
			ArrayList<User> listOfUsers2 = (ArrayList<User>) App.resources.getDaoUser().getAll();
			for (User user : listOfUsers2) {
				listOfUsersTable2.add(new UserTable(user));
			}
			ObservableList<UserTable> data2 = FXCollections.observableArrayList(listOfUsersTable2);
			table.setItems(data2);
		});

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table, refresh);

		return vbox;
	}

	private static HBox addMenu() {
		HBox addMenu = new HBox();
		VBox menu = new VBox();

		final Label options = new Label("Options: ");
		final Label userManagement = new Label("User Management: ");
		final Label teamManagement = new Label("Team Management: ");
		// TODO
		String requestsNr = "TODO";
		final Label requestTag = new Label("You have " + requestsNr + "requests!");
		options.setId("title");

		Button requests = new Button("View Requests");
		requests.getStyleClass().add("fancy-button");
		requests.setOnAction(e -> {

		});

		Button addNewUser = new Button("Create New User");
		addNewUser.getStyleClass().add("fancy-button");
		addNewUser.setOnAction(e -> {
			NewUserScene.scene();
		});

		Button editSelectedUser = new Button("Edit Selected User");
		editSelectedUser.getStyleClass().add("fancy-button");
		editSelectedUser.setOnAction(e -> {

		});

		Button archiveUser = new Button("Archive User");
		archiveUser.getStyleClass().add("fancy-button");
		archiveUser.setOnAction(e -> {

		});

		Button newTeam = new Button("Create New Team");
		newTeam.getStyleClass().add("fancy-button");
		newTeam.setOnAction(e -> {

		});

		Button settings = new Button("Settings");
		settings.getStyleClass().add("fancy-button");
		settings.setOnAction(e -> {

		});

		Button deleteTeam = new Button("Delete a Team");
		deleteTeam.getStyleClass().add("fancy-button");
		deleteTeam.setOnAction(e -> {

		});

		menu.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		menu.setAlignment(Pos.CENTER);
		menu.setSpacing(20);
		menu.getChildren().addAll(options, userManagement, addNewUser, editSelectedUser, archiveUser, teamManagement,
				newTeam, deleteTeam, requestTag, requests, settings);

		final Label shadow = new Label("   ");

		addMenu.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		addMenu.setAlignment(Pos.CENTER);
		addMenu.setSpacing(10);
		addMenu.getChildren().addAll(shadow, menu);

		return addMenu;
	}

	private static VBox addTop() {

		VBox vBox = new VBox();
		HBox showTable = new HBox();

		Button admin = new Button("Admins");
		admin.getStyleClass().add("fancy-button");
		admin.setOnAction(e -> {

		});

		Button arhived = new Button("Arhived");
		arhived.getStyleClass().add("fancy-button");
		arhived.setOnAction(e -> {

		});

		ChoiceBox<String> teams = new ChoiceBox<>();
		List<TeamOfRecruitment> teamOfRec = App.resources.getDaoTeamRec().getAll();
		teams.getItems().addAll("team 1", "team 2", "team 3", "team 4");
		teams.setValue("team 1");
		for (TeamOfRecruitment teamOfRecruitment : teamOfRec) {
			teams.getItems().add(teamOfRecruitment.getName());
		}

		teams.getSelectionModel().selectedItemProperty()
				.addListener((v, oldValue, newValue) -> System.out.println("test"));

		showTable.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		showTable.setAlignment(Pos.CENTER);
		showTable.setSpacing(30);
		showTable.getChildren().addAll(admin, arhived, teams);

		final Label shadow = new Label("");
		final Label select = new Label("Select to view:");
		final Label view = new Label("Your are viewing all users:");
		select.setId("text-1");

		vBox.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(select, showTable, shadow, view);
		vBox.setSpacing(10);

		return vBox;
	}

}
