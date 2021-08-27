package projectRecruiterPlus.Util.Interface;

import java.util.Date;
import java.util.List;

import projectRecruiterPlus.Entities.User;

public interface UserAccess {

	List<User> getByBirthday(Date date);
	
	List<User> getByFirstDayWork(Date date);
	
	List<User> getByLastDayWork(Date date);
	
	List<User> getByTimeInCompany(Date date);
	
	List<User> getBySalary(double moreThem, double lessThem);
	
	
}
