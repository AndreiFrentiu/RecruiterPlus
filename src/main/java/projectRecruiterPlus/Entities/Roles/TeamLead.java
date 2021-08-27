package projectRecruiterPlus.Entities.Roles;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.TeamLeadInterface;

//lombok help
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

//hibernate settings
@Entity
@Table
@DiscriminatorValue("Teamlead")
public class TeamLead extends CompanyRole implements TeamLeadInterface{

	@OneToOne(cascade = CascadeType.ALL)
	private TeamOfRecruitment team;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Manager manager;
	
	public TeamLead(User user) {
		super.acessLevel = 2;
		super.name = "Recruitment Team Leader";
		super.description = "The Team Leader manages an team. "
				+ "The TeamLead request projects from tha manager. Asigns the projects to the team."
				+ "Looks at statistics from the team and specific recruiter";
		super.points = 1.0f;
		super.user = user;
	}

	@Override
	public String toString() {
		return "TeamLead [team=" + team + ", manager=" + manager + ", id=" + id + ", name=" + name + ", points="
				+ points + ", description=" + description + ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}
	
	
}
