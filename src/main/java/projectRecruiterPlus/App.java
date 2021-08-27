package projectRecruiterPlus;

import javafx.application.Application;
import javafx.stage.Stage;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.AppAdmin;
import projectRecruiterPlus.Entities.Roles.CompanyRole;
import projectRecruiterPlus.Entities.Roles.Manager;
import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Entities.Roles.TeamLead;
import projectRecruiterPlus.Util.Other.Resources;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;
import projectRecruiterPlus.graphicsInterface.Scenes.LogInScene;

public class App extends Application {

	public static Resources resources;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		resources = new Resources();
		LogInScene.scene(primaryStage);
		addinfo();

		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			if (AlertBoxExit.display()) {
				primaryStage.close();
			}
		});
	}

	private void addinfo() {
		User user = new User("1", "1");
		try {
			resources.getDaoUser().save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyRole companyrole = new Manager(user);
		resources.getSession().save(companyrole);

		User user2 = new User("2", "2");
		try {
			resources.getDaoUser().save(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyRole companyrole2 = new Recruiter(user2);
		resources.getSession().save(companyrole2);

		User user3 = new User("5", "5");
		try {
			resources.getDaoUser().save(user3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyRole companyrole3 = new AppAdmin(user3);
		resources.getSession().save(companyrole3);

	}

}
