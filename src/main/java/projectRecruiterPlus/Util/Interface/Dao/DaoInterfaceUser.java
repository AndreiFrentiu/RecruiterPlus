package projectRecruiterPlus.Util.Interface.Dao;

import java.time.LocalDate;
import java.util.List;

import projectRecruiterPlus.Entities.User;
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
	
	boolean terminate(User u, LocalDate date);
	
	boolean updateDetails(User u, String[] args);

	
}
