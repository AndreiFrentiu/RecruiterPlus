package projectRecruiterPlus.Entities.Roles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import projectRecruiterPlus.Entities.User;

@Entity
@Table
@DiscriminatorValue("Admin")
public class AppAdmin extends CompanyRole{

	public AppAdmin(User user) {
		super.acessLevel = 0;
		super.name = "Application Admin";
		super.description = "The Admin is the administrator of the App that has acces to personal data of the users and cand create or delete users. "
				+ " It is the only role that can change the Manager";
		super.points=0;
		super.user = user;
	}
}
