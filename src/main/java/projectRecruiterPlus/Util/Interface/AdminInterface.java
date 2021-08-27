package projectRecruiterPlus.Util.Interface;

import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.CompanyRole;
import projectRecruiterPlus.Entities.Roles.Manager;

public interface AdminInterface {

	/* level 0 access: */
	boolean archiveUser(User user);
	
	boolean editUser(User user);
	
	boolean addUser(User user, CompanyRole compRole);
	
	boolean archiveManager(Manager manager);
	
	boolean editManager(Manager manager);
	
	boolean addManager(Manager manager);
	
	boolean setRole(User user);
}









