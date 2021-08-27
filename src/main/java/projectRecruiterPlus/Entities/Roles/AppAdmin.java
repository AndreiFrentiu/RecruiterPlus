package projectRecruiterPlus.Entities.Roles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.Interface.AdminInterface;

//hibernate settings
@Entity
@Table
@DiscriminatorValue("Admin")
public class AppAdmin extends CompanyRole implements AdminInterface{

	public AppAdmin(User user) {
		super.acessLevel = 0;
		super.name = "Application Admin";
		super.description = "The Admin is the administrator of the App that has acces to personal data of the users and cand create or delete users. "
				+ " It is the only role that can change the Manager";
		super.points=0;
		super.user = user;
	}

	@Override
	public boolean archiveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user, CompanyRole compRole) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean archiveManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setRole(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
