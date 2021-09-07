package projectRecruiterPlus;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.stage.Stage;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.AppAdmin;
import projectRecruiterPlus.Entities.Roles.CompanyRole;
import projectRecruiterPlus.Entities.Roles.Manager;
import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Util.Other.Resources;
import projectRecruiterPlus.Util.Other.TimeCounter;
import projectRecruiterPlus.graphicsInterface.Alerts.AlertBoxExit;
import projectRecruiterPlus.graphicsInterface.Scenes.LogInScene;

public class App extends Application {

	public static Resources resources;
	public static TimeCounter timeCounter;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		resources = new Resources();
		LogInScene.scene(primaryStage);
		timeCounter = new TimeCounter();	
		addinfo();

		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			if (AlertBoxExit.display()) {
				primaryStage.close();
				timeCounter.stopCount();
			}
		});
	}

	private void addinfo() {
		User user2 = new User("error", "error");
		user2.setFirstName("Error");
		try {
			resources.getDaoUser().save(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user = new User("1", "1");
		user.setAdress("test");
		LocalDate thisTime = LocalDate.now();
		user.setBirthday(thisTime);
		user.setFirstDayWork(thisTime);
		CompanyRole cr = new CompanyRole();
		cr.setName("da");
		user.setCompanyRole(cr);
		user.setContactNumber(52374120);
		user.setEmail("thebest@yahoo.com");
		user.setFirstName("Gigel");
		user.setGrossSalary(130000.0);
		user.setLastDayWork(thisTime);
		user.setLastName("Mitica");
		user.setNetSalary(120.0);
		user.setVacationDays(12);
		TeamOfRecruitment team = new TeamOfRecruitment();
		resources.getSession().save(team);
		team.setName("Elite");
		user.setTeam(team);
		try {
			resources.getDaoUser().save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyRole companyrole = new Manager(user);
		resources.getSession().save(companyrole);

		CompanyRole companyrole2 = new Recruiter(user2);
		resources.getSession().save(companyrole2);

		User user3 = new User("2", "2");
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
