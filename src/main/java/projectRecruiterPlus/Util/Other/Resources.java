package projectRecruiterPlus.Util.Other;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Util.DAO.DaoManager;
import projectRecruiterPlus.Util.DAO.DaoRecruiter;
import projectRecruiterPlus.Util.DAO.DaoRecruiterRank;
import projectRecruiterPlus.Util.DAO.DaoTeamLead;
import projectRecruiterPlus.Util.DAO.DaoTeamOfRecruitment;
import projectRecruiterPlus.Util.DAO.DaoUser;
import projectRecruiterPlus.Util.Hibernate.HibernateUtil;

@Setter
@Getter
@AllArgsConstructor

public class Resources {

	private User mainUser;

	private Session session;
	private Transaction transaction;
	private DaoUser daoUser;
	private DaoTeamOfRecruitment DaoTeamRec;
	private DaoRecruiterRank DaoRecRank;
	private DaoRecruiter DaoRec;
	private DaoManager DaoManager;
	private DaoTeamLead daoTeamLead;

	public Resources() throws Exception {
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.transaction = session.beginTransaction();
		this.daoUser = new DaoUser(session, transaction);
		this.DaoTeamRec = new DaoTeamOfRecruitment(session, transaction);
		this.DaoRecRank = new DaoRecruiterRank(session, transaction);
		this.DaoRec = new DaoRecruiter(session, transaction);
		this.DaoManager = new DaoManager(session, transaction);
		this.daoTeamLead = new DaoTeamLead(session, transaction);
	}

	public void stopSessionAndTransaction() {
		session.close();
		transaction.commit();
	}

}
