package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Util.Interface.Dao.DaoInterfaceSupportClass;

public class DaoTeamOfRecruitment implements DaoInterfaceSupportClass<TeamOfRecruitment> {

	private Session session;
	private Transaction transaction;

	public DaoTeamOfRecruitment(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
	}

	@Override
	public boolean save(TeamOfRecruitment team) {
		try {
			session.save(team);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TeamOfRecruitment getById(int id) {
		TeamOfRecruitment team = session.get(TeamOfRecruitment.class, id);
		return team;
	}

	@Override
	public TeamOfRecruitment getByName(String name) {
		Query<TeamOfRecruitment> query = session.createQuery("from TeamOfRecruitment where name = :parameter1");
		query.setParameter("parameter1", name);
		ArrayList<TeamOfRecruitment> list = (ArrayList<TeamOfRecruitment>) query.list();
		TeamOfRecruitment team = list.get(0);
		return team;
	}

	@Override
	public List<TeamOfRecruitment> getAll() {
		Query<TeamOfRecruitment> query = session.createQuery("from TeamOfRecruitment");
		ArrayList<TeamOfRecruitment> list = (ArrayList<TeamOfRecruitment>) query.list();	
		return list;
	}

	@Override
	public boolean delete(TeamOfRecruitment team) {
		Query query = session.createQuery("Delete from TeamOFRecruitment where id = :par1");
		query.setParameter("par1", team.getId());
		if(query.executeUpdate()==1) {
			return true;
		} else {
			return false;
		}
	}
}
