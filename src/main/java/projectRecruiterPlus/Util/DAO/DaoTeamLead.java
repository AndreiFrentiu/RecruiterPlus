package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Entities.Roles.TeamLead;
import projectRecruiterPlus.Util.Interface.Dao.DaoInterfaceSupportClass;

public class DaoTeamLead implements DaoInterfaceSupportClass<TeamLead> {

	private Session session;
	private Transaction transaction;

	public DaoTeamLead(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
	}
	
	@Override
	public boolean save(TeamLead teamLead) {
		try {
			session.save(teamLead);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TeamLead getById(int id) {
		TeamLead teamLead = session.get(TeamLead.class, id);
		return teamLead;
	}

	@Override
	public TeamLead getByName(String name) {
		Query<TeamLead> query = session.createQuery("from TeamLead where name = :parameter1");
		query.setParameter("parameter1", name);
		ArrayList<TeamLead> list = (ArrayList<TeamLead>) query.list();
		TeamLead teamLead = list.get(0);
		return teamLead;
	}

	@Override
	public List<TeamLead> getAll() {
		Query<TeamLead> query = session.createQuery("from TeamLead");
		ArrayList<TeamLead> teamLeads = (ArrayList<TeamLead>) query.list();	
		return teamLeads;
	}

	@Override
	public boolean delete(TeamLead teamLead) {
		Query query = session.createQuery("Delete from TeamLead where id = :par1");
		query.setParameter("par1", teamLead.getId());
		if(query.executeUpdate()==1) {
			return true;
		} else {
			return false;
		}
	}

}
