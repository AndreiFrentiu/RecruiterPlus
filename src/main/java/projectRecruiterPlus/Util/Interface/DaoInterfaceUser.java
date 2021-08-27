package projectRecruiterPlus.Util.Interface;

import java.util.Date;
import java.util.List;

import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.CompanyRole;
import projectRecruiterPlus.Util.Other.CompanyRoleType;

public interface DaoInterfaceUser {

	boolean verifyIfExists(User u);

	boolean verifyPassword(User u);

	void save (User u) throws Exception;

	User getById(int id);
	
	User getbyUsername(String username);
	
	List<User> getAll();
	
	List<User> getByCompanyRole(CompanyRoleType role);
	
	List<User> getTeamOfRecruitment(String teamName);
	
	//delete
	void deleteUser(User u);

	//update
	boolean changePassword(User u, String s);
	
	boolean updateUsername(User u, String username);
	
	boolean promote(User u, CompanyRole role);
	
	boolean terminate(User u, Date date);
	
	boolean updateDetails(User u, String[] args);

	
}