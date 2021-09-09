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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@DiscriminatorValue("Teamlead")
public class TeamLead extends CompanyRole {

	public final static float defaultPoint = 1.0f;
	public final static int defaultAcces = 2;
	public final static String defaultName = "Recruitment Team Leader";
	public final static String defaultDescription =  "The Team Leader manages an team. "
			+ "The TeamLead request projects from tha manager. Asigns the projects to the team."
			+ "Looks at statistics from the team and specific recruiter";

	
	@OneToOne(cascade = CascadeType.ALL)
	private TeamOfRecruitment team;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Manager manager;
	
	public TeamLead(User user) {
		super.acessLevel = defaultAcces;
		super.name = defaultName;
		super.description = defaultDescription;
		super.points =defaultPoint;
		super.user = user;
	}
	
	@Override
	public String toString() {
		return "TeamLead [team=" + team + ", manager=" + manager + ", id=" + id + ", name=" + name + ", points="
				+ points + ", description=" + description + ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}
	
	
}
