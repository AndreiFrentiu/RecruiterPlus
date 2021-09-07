package projectRecruiterPlus.graphicsInterface.Scenes;


import java.util.List;

import javafx.geometry.Pos;
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
import projectRecruiterPlus.Util.Interface.Scenes.AdminSceneAbstract;
import projectRecruiterPlus.Util.Table.TableOfUsers;

public class AdminScene extends AdminSceneAbstract {

	private static TableOfUsers tableOfUsers = new TableOfUsers();
	
	public static void setScene(Stage window) {
		BorderPane bp = new BorderPane();
		Scene scene2_Admin = new Scene(bp);
		
		bp.setLeft(addMenu());
		bp.setTop(addTop());
		bp.setCenter(addTable());
		bp.setStyle("-fx-background-image: url(\"/projectRecruiterPlus/graphicsInterface/CSS/imgs/adminbk.jpg\");"
				+ " -fx-background-repeat: no-repeat;" + "	-fx-background-size: stretch;");
		
		window.setScene(scene2_Admin);
		window.setMaximized(true);
		window.show();
	}
	
	private static HBox addMenu() {
		HBox addMenu = new HBox();
		VBox menu = new VBox();

		final Label options = new Label("Options: ");
		final Label userManagement = new Label("User Management: ");
		final Label teamManagement = new Label("Team Management: ");
		final Label shadow = new Label("   ");
		
		// TODO
		String requestsNr = "TODO";
		final Label requestTag = new Label("You have " + requestsNr + "requests!");
		
		Button requests = new Button("View Requests");
		Button addNewUser = new Button("Create New User");
		Button editSelectedUser = new Button("Edit Selected User");
		Button archiveUser = new Button("Archive User");
		Button newTeam = new Button("Create New Team");
		Button settings = new Button("Settings");
		Button deleteTeam = new Button("Delete a Team");
		
		requests.getStyleClass().add("fancy-button");
		requests.setOnAction(e -> {

		});

		addNewUser.getStyleClass().add("fancy-button");
		addNewUser.setOnAction(e -> {
			NewUserScene newUserScene = new NewUserScene();
			newUserScene.setScene();
		});

		editSelectedUser.getStyleClass().add("fancy-button");
		editSelectedUser.setOnAction(e -> {

		});

		archiveUser.getStyleClass().add("fancy-button");
		archiveUser.setOnAction(e -> {

		});
		
		newTeam.getStyleClass().add("fancy-button");
		newTeam.setOnAction(e -> {

		});
		
		settings.getStyleClass().add("fancy-button");
		settings.setOnAction(e -> {

		});
		
		deleteTeam.getStyleClass().add("fancy-button");
		deleteTeam.setOnAction(e -> {

		});
		
		options.setId("title");

		menu.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		menu.setAlignment(Pos.CENTER);
		menu.setSpacing(20);
		menu.getChildren().addAll(options, userManagement, addNewUser, editSelectedUser, archiveUser, teamManagement,
				newTeam, deleteTeam, requestTag, requests, settings);

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
		Button arhived = new Button("Arhived");
		ChoiceBox<String> teams = new ChoiceBox<>();
		final Label shadow = new Label("");
		final Label select = new Label("Select to view:");
		final Label view = new Label("Your are viewing all users:");
		
		admin.getStyleClass().add("fancy-button");
		admin.setOnAction(e -> {

		});

		arhived.getStyleClass().add("fancy-button");
		arhived.setOnAction(e -> {

		});
		
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

		select.setId("text-1");

		vBox.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAdminScene.css");
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(select, showTable, shadow, view);
		vBox.setSpacing(10);

		return vBox;
	}

	private static VBox addTable() {
		return tableOfUsers.addVBoxTable();
	}

}
