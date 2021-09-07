package projectRecruiterPlus.Entities.Roles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;

@Setter
@Getter
@Entity
@Table
@DiscriminatorValue("Recruiter")
public class Recruiter extends CompanyRole {

	// TODO create 3 new ranks from recruiter that have more points to do and trains
	// a new recruiter
	public Recruiter(User user) {
		super.acessLevel = 1;
		super.name = "Recruiter";
		super.description = "This role has the responsability to" + " manage projects and the database of candidates"
				+ "This user can request Free time, projects, end projects and rankUp";
		super.points = 1.0f;
		super.user = user;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", name=" + name + ", points=" + points + ", description=" + description
				+ ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}
	
	

}
