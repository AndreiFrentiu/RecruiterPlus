package projectRecruiterPlus.graphicsInterface.Scenes.NewUser.Roles;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.RecruiterRank;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.graphicsInterface.Alerts.CustomAlertBox;

public class NewRecruiterScene {
	
	VBox recruiterBox = new VBox(5);
	GridPane recruiterGrid = new GridPane();
	
	ChoiceBox<String> ranks = new ChoiceBox<>();
	ArrayList<RecruiterRank> recruiterRanks;
	
	final Label nameTag = new Label("Position Name:");
	final Label pointsTag = new Label("Points:");
	final Label levelTag = new Label("Acces Level:");
	final Label descriptTag = new Label("Description:");

	final Label nameInfo = new Label(" Position Name! ");
	final Label pointsInfo = new Label(" Points! ");
	final Label levelInfo = new Label(" Acces Level! ");
	final Label descriptInfo = new Label(" Description! ");

	
	public NewRecruiterScene() {
		this.recruiterRanks = (ArrayList<RecruiterRank>) App.resources.getDaoRecRank().getAll();
		
		nameInfo.setText(Recruiter.defaultName);
		pointsInfo.setText(Float.toString(Recruiter.defaultPoint));
		levelInfo.setText(Integer.toString(Recruiter.defaultAcces));	
		descriptInfo.setText(Recruiter.defaultDescription);
	}
	
	public RecruiterRank getChoice() {
		return App.resources.getDaoRecRank().getByName(ranks.getValue());
	}
	
	public VBox addRecruiterOptionContent() {
		
		recruiterGrid.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAddUserScene.css");
		
		editLabels();
		
		editChoiceBox();
		
		editGrid();

		recruiterBox.getChildren().addAll(recruiterGrid, ranks);
		recruiterBox.setAlignment(Pos.CENTER);
		
		return recruiterBox;
	}
	
	private void editLabels() {
		
		nameInfo.setMinHeight(40);
		pointsInfo.setMinHeight(40);
		levelInfo.setMinHeight(40);
		
		descriptInfo.setMinSize(400, 150);
		descriptInfo.setMaxSize(400, 150);
		descriptInfo.setWrapText(true);
		
		nameTag.getStyleClass().add("bigLabel");
		pointsTag.getStyleClass().add("bigLabel");
		levelTag.getStyleClass().add("bigLabel");
		descriptTag.getStyleClass().add("bigLabel");

		nameInfo.getStyleClass().add("borderedLabel");
		pointsInfo.getStyleClass().add("borderedLabel");
		levelInfo.getStyleClass().add("borderedLabel");
		descriptInfo.getStyleClass().add("borderedLabel");
	}
	
	private void editGrid() {
		recruiterGrid.setHgap(10);
		recruiterGrid.setVgap(12);
		recruiterGrid.setAlignment(Pos.CENTER);
		recruiterGrid.add(nameTag, 0, 0);
		recruiterGrid.add(nameInfo, 1, 0);
		recruiterGrid.add(pointsTag, 0, 1);
		recruiterGrid.add(pointsInfo, 1, 1);
		recruiterGrid.add(levelTag, 0, 2);
		recruiterGrid.add(levelInfo, 1, 2);
		recruiterGrid.add(descriptTag, 0, 3);
		recruiterGrid.add(descriptInfo, 1, 3);
		recruiterGrid.setAlignment(Pos.CENTER);
	}
	
	private void editChoiceBox() {
		for (RecruiterRank recruiterRank : recruiterRanks) {
			ranks.getItems().add(recruiterRank.getRankName());
		}
		
		ranks.getSelectionModel().selectedItemProperty()
		.addListener((v, oldValue, newValue) -> {
			if (newValue.equals("Default Recruiter")) {
				nameInfo.setText("  " + Recruiter.defaultName + "  ");
				pointsInfo.setText("  " + Float.toString(Recruiter.defaultPoint) + "  ");
				levelInfo.setText("  " + Integer.toString(Recruiter.defaultAcces) + "  ");	
				descriptInfo.setText(Recruiter.defaultDescription);
			}
			for (RecruiterRank recruiterRank : recruiterRanks) {
				if(newValue.equals(recruiterRank.getRankName())) {
					nameInfo.setText("  " + recruiterRank.getRankName() + "  ");
					pointsInfo.setText("  " + Float.toString(recruiterRank.getPoints()) + "  ");
					levelInfo.setText("  " + Integer.toString(recruiterRank.getAccesLevel()) + "  ");	
					descriptInfo.setText(recruiterRank.getDescription());
				}
			}
		});
		
		ranks.getItems().add("Default Recruiter");
		ranks.setValue("Default Recruiter");
	}

	public VBox addFinishButton(User newUser, Stage window) {
		final Label space = new Label(" ");
		HBox hbox = new HBox(5);
		VBox vbox = new VBox(5);
		Button finish = new Button("Finish");
		Button back = new Button("Abort");
		finish.getStyleClass().add("fancy-button");
		
		finish.setOnAction(e -> {
			Recruiter newRecruiter;
			RecruiterRank rank;
			if(ranks.getValue().toString().equals("Default Recruiter")) {
				newRecruiter = new Recruiter(newUser);
			} else {
				rank = App.resources.getDaoRecRank().getByName(ranks.getValue().toString());
				newRecruiter = new Recruiter(newUser, rank);
			}
			newUser.setRol(newRecruiter);	
			try {
				App.resources.getDaoRec().save(newRecruiter);
				App.resources.getDaoUser().save(newUser);
				window.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		back.getStyleClass().add("fancy-button");
		back.setOnAction(e -> {
			CustomAlertBox abort = new CustomAlertBox("Are you sure you want to abort ?", "Abort", "Go back");
			if(abort.display()) {
				window.close();
			}
		});
		
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(back, finish);

		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox, space);

		return vbox;
	}
}
