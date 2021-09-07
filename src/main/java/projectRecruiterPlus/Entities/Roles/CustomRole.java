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
@DiscriminatorValue("Customrole")
public class CustomRole extends CompanyRole {

	public CustomRole(User user, int accesLevel, String name, String description, float points) {
		super.acessLevel = accesLevel;
		super.name = name;
		super.description = description;
		super.points=points;
		super.user = user;
	}

	@Override
	public String toString() {
		return "CustomRole [id=" + id + ", name=" + name + ", points=" + points + ", description=" + description
				+ ", acessLevel=" + acessLevel + ", user=" + user + "]";
	}
	
}
