package projectRecruiterPlus.graphicsInterface.Scenes;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.Scenes.AdminSceneAbstract;
import projectRecruiterPlus.Util.Other.CompanyRoleType;

public class AdminScene extends AdminSceneAbstract {

	public static void scene(Stage window) {

		BorderPane bp = new BorderPane();
		bp.setLeft(addMenu());
		bp.setTop(addBot());
		bp.setCenter(addTable());
		bp.setStyle("-fx-background-image: url(\"/projectRecruiterPlus/graphicsInterface/CSS/imgs/adminbk.jpg\");"
				+ " -fx-background-repeat: no-repeat;" + "	-fx-background-size: stretch;");

		Button testButton = new Button("test");
		testButton.getStyleClass().add("fancy-button");
		testButton.setOnAction(e -> {
			User user = new User("1", "1");
			System.out.println(App.resources.getDaoUser().updateUsername(user, "test"));
		});

		Scene scene2_Admin = new Scene(bp);
		window.setScene(scene2_Admin);
		window.setMaximized(true);
		window.show();
	}

	private static Node addTable() {

		return null;
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

	private static VBox addBot() {

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
		
		teams.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println("test"));

		showTable.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		showTable.setAlignment(Pos.CENTER);
		showTable.setSpacing(30);
		showTable.getChildren().addAll(admin, arhived, teams);

		final Label shadow = new Label("");
		final Label select = new Label("Select to view:");
		select.setId("text-1");

		vBox.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(select, showTable, shadow);
		vBox.setSpacing(10);

		return vBox;
	}

}
