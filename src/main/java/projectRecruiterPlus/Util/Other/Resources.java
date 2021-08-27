package projectRecruiterPlus.Util.Other;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import projectRecruiterPlus.Entities.User;
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
	
	public Resources() throws Exception  {
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.transaction = session.beginTransaction();
		this.daoUser = new DaoUser(session, transaction);
	}
	
	public void stopSessionAndTransaction() {
		session.close();
		transaction.commit();
	}
	

	
}
