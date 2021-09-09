package projectRecruiterPlus.graphicsInterface.Scenes.NewUser.Roles;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.Manager;
import projectRecruiterPlus.Entities.Roles.TeamLead;
import projectRecruiterPlus.graphicsInterface.Alerts.CustomAlertBox;

public class NewManagerScene {

	VBox managerBox = new VBox(5);
	GridPane managerGrid = new GridPane();

	final Label descriptTag = new Label("Description:");
	final Label descriptInfo = new Label(" Description! ");

	final Label levelTag = new Label("Acces Level:");
	final Label levelInfo = new Label(" Acces Level! ");

	final Label nameTag = new Label("Position Name:");
	final Label nameInfo = new Label(" Position Name! ");

	public VBox addManagerOptionContent() {

		managerGrid.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAddUserScene.css");

		editLabels();

		editGrid();

		managerBox.getChildren().addAll(managerGrid);
		managerBox.setAlignment(Pos.CENTER);

		return managerBox;
	}

	private void editLabels() {

		nameInfo.setText("  " + Manager.defaultName + "  ");
		levelInfo.setText("  " + Integer.toString(Manager.defaultAccesLvl) + "  ");
		descriptInfo.setText(Manager.defaultDescription);

		nameInfo.setMinHeight(40);
		levelInfo.setMinHeight(40);

		descriptInfo.setMinSize(400, 150);
		descriptInfo.setMaxSize(400, 150);
		descriptInfo.setWrapText(true);

		nameTag.getStyleClass().add("bigLabel");
		levelTag.getStyleClass().add("bigLabel");
		descriptTag.getStyleClass().add("bigLabel");

		nameInfo.getStyleClass().add("borderedLabel");
		levelInfo.getStyleClass().add("borderedLabel");
		descriptInfo.getStyleClass().add("borderedLabel");
	}

	private void editGrid() {
		managerGrid.setHgap(10);
		managerGrid.setVgap(12);
		managerGrid.setAlignment(Pos.CENTER);
		managerGrid.add(nameTag, 0, 0);
		managerGrid.add(nameInfo, 1, 0);
		managerGrid.add(levelTag, 0, 1);
		managerGrid.add(levelInfo, 1, 1);
		managerGrid.add(descriptTag, 0, 2);
		managerGrid.add(descriptInfo, 1, 2);
		managerGrid.setAlignment(Pos.CENTER);
	}

	public VBox addFinishButton(User newUser, Stage window) {
		final Label space = new Label(" ");
		HBox hbox = new HBox(5);
		VBox vbox = new VBox(5);
		Button finish = new Button("Finish");
		Button back = new Button("Abort");
		finish.getStyleClass().add("fancy-button");
		finish.setOnAction(e -> {			
			try {
				ArrayList<Manager> managers = (ArrayList<Manager>) App.resources.getDaoManager().getAll();
				System.out.println(managers.size());
				for (Manager manager : managers) {
					if (manager.getUser().isActiveAccount()) {
						CustomAlertBox customBox = new CustomAlertBox(
								"There is an active admin at this moment. Do you wish to change it with the new user ?",
								"Yes", "No");
						if (customBox.display()) {
							Manager newManager = new Manager();
							newUser.setRol(newManager);
							changeManager(newManager, newUser);
						}
						window.close();
					}
				}
				Manager newManager = new Manager();
				newUser.setRol(newManager);
				changeManager(newManager, newUser);
				window.close();
			} catch (Exception e1) {
				e1.printStackTrace();
				System.err.println("It is posible that the user is not saved");
			}
		});

		back.getStyleClass().add("fancy-button");
		back.setOnAction(e -> {
			CustomAlertBox abort = new CustomAlertBox("Are you sure you want to abort ?", "Abort", "Go back");
			if (abort.display()) {
				window.close();
			}
		});

		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(back, finish);

		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, space);

		return vbox;
	}

	private void changeManager(Manager newManager, User newUser) throws Exception {
		ArrayList<TeamLead> teamLeads = (ArrayList<TeamLead>) App.resources.getDaoTeamLead().getAll();
		for (TeamLead teamLead : teamLeads) {
			teamLead.setManager(newManager);
		}
		App.resources.getDaoManager().save(newManager);
		App.resources.getDaoUser().save(newUser);

	}

}
