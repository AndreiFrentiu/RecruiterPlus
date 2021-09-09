package projectRecruiterPlus.graphicsInterface.Scenes.NewUser;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;
import projectRecruiterPlus.graphicsInterface.Scenes.NewUser.Roles.NewManagerScene;
import projectRecruiterPlus.graphicsInterface.Scenes.NewUser.Roles.NewRecruiterScene;
import projectRecruiterPlus.graphicsInterface.Scenes.NewUser.Roles.NewTeamLeadScene;

@AllArgsConstructor
@Setter
@Getter
public class NewUserSecondScene {

	private Stage window;
	private User newUser;
	private String roleChoice;
	
	public NewUserSecondScene(Stage window, User newUser) {
		this.window = window;
		this.newUser = newUser;
	}
	
	public void setScene(String role) {

		BorderPane border = new BorderPane();
		Scene scene4_newUser = new Scene(border, 720, 520);
		roleChoice = role;
		
		if (role.equals("Manager")) {
			NewManagerScene managScene = new NewManagerScene();
			border.setCenter(managScene.addManagerOptionContent());
			border.setBottom(managScene.addFinishButton(newUser, window));
		}
		if (role.equals("TeamLead")) {
			NewTeamLeadScene teamLeadScene = new NewTeamLeadScene();
			//TODO
			//border.setCenter(teamLeadScene.addTeamLeadOptionContent());
			//border.setBottom(teamLeadScene.addFinishButton(newUser, window));
		}
		if (role.equals("Recruiter")) {
			NewRecruiterScene recScene = new NewRecruiterScene();
			border.setCenter(recScene.addRecruiterOptionContent());
			border.setBottom(recScene.addFinishButton(newUser, window));
		}
		if (role.equals("Application Admin"))
			border.setCenter(addAdminOptionContent());
		border.getStylesheets().add("projectRecruiterPlus/graphicsInterface/CSS/styleAddUserScene.css");
		window.setScene(scene4_newUser);
		window.setOnCloseRequest(e -> {
			e.consume();
			AlertBoxExit alertBox = new AlertBoxExit();
			if (alertBox.display())
				window.close();
		});
	}
	
	public void closeWindow() {
		window.close();
	}

	private Node addAdminOptionContent() {
		// TODO Auto-generated method stub
		return null;
	}




}
