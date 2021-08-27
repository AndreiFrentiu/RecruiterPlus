package projectRecruiterPlus.Entities.Roles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.ManagerInterface;

//Lombok
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

//hibernate settings
@Entity
@Table
@DiscriminatorValue("Manager")
public class Manager extends CompanyRole implements ManagerInterface {

	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private List<TeamLead> teamLeaders;
	
	public Manager(User user) {
		super.acessLevel = 3;
		super.name = "Recruitment Manager";
		super.description = "The role of the manager is to create projects,"
				+ " asign project to the TeamLead, edit the Of-Limits-Companies,"
				+ " generate statistics of a team or a user, "
				+ "direct comunication with the TeamLead and aproves requests from the Teamleads";
		super.points = 0;
		super.user = user;
	}

	@Override
	public String toString() {
		return "Manager [teamLeaders=" + teamLeaders + ", id=" + id + ", name=" + name + ", points=" + points
				+ ", description=" + description + ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}
	
	
}
