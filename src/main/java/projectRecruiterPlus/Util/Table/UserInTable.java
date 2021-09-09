package projectRecruiterPlus.Util.Table;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;

@Setter
@Getter
public class UserInTable {

	private String firstName;
	private String lastName;
	private String email;
	private String adress;
	private String username;
	private LocalDate birthday;
	private LocalDate firstDayWork;
	private LocalDate lastDayWork;
	private double grossSalary;
	private double netSalary;
	private int vacationDays;
	private String roleName;
	private String team;

	public UserInTable(User user) {

		if (user.getFirstName() == null)
			this.firstName = "no data";
		else
			this.firstName = user.getFirstName();

		if (user.getLastName() == null)
			this.lastName = "no data";
		else
			this.lastName = user.getLastName();

		if (user.getEmail() == null)
			this.email = "no data";
		else
			this.email = user.getEmail();

		if (user.getAdress() == null)
			this.adress = "no data";
		else
			this.adress = user.getAdress();

		if (user.getUsername() == null)
			this.username = "no data";
		else
			this.username = user.getUsername();

		if (user.getBirthday() == null)
			this.birthday = LocalDate.EPOCH;
		else
			this.birthday = user.getBirthday();

		try {
			this.team = user.getTeam().getName();
		} catch (Exception e) {
			this.team = "no data";
		}

		try {
			this.firstDayWork = user.getFirstDayWork();
		} catch (Exception e) {
			this.firstDayWork = LocalDate.EPOCH;
		}

		try {
			this.lastDayWork = user.getLastDayWork();
		} catch (Exception e) {
			this.lastDayWork = LocalDate.EPOCH;
		}

		try {
			this.roleName = user.getRol().getName();
		} catch (Exception e) {
			this.roleName = "no data";
		}

		this.grossSalary = user.getGrossSalary();
		this.netSalary = user.getNetSalary();
		this.vacationDays = user.getVacationDays();

	}

}
