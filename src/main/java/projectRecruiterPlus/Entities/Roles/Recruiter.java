package projectRecruiterPlus.Entities.Roles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.RecruiterRank;
import projectRecruiterPlus.Entities.User;

@Setter
@Getter
@Entity
@Table
@DiscriminatorValue("Recruiter")
public class Recruiter extends CompanyRole {

	public final static float defaultPoint = 1.0f;
	public final static int defaultAcces = 1;
	public final static String defaultName = "Recruiter";
	public final static String defaultDescription = "This role has the responsability to"
			+ " manage projects and the database of candidates."
			+ " This user can request Free time and projects. The user can also end projects and rankUp.";
	
	public Recruiter(User user) {
		super.acessLevel = defaultAcces;
		super.name = defaultName;
		super.description = defaultDescription;
		super.points = defaultPoint;
		super.user = user;
	}

	public Recruiter(User user, RecruiterRank rank) {
		super.acessLevel = 1;
		super.name = rank.getRankName();
		super.description = rank.getDescription();
		super.points = rank.getPoints();
		super.user = user;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", name=" + name + ", points=" + points + ", description=" + description
				+ ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}

}
