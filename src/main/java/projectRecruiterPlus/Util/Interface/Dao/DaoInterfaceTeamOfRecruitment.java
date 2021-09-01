package projectRecruiterPlus.Util.Interface.Dao;

import java.util.List;

import projectRecruiterPlus.Entities.TeamOfRecruitment;

public interface DaoInterfaceTeamOfRecruitment {

	boolean save(TeamOfRecruitment team);
	
	TeamOfRecruitment getById(int id);
	
	TeamOfRecruitment getByName(String name);
	
	List<TeamOfRecruitment> getAll();
	
	boolean deleteTeamOfRecruitment(TeamOfRecruitment team);
}
